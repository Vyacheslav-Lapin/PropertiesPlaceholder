package ru.vlapin.experiments.PropertiesPlaceholder;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.experiments.PropertiesPlaceholder.model.jsonplaceholder.Post;
import ru.vlapin.experiments.PropertiesPlaceholder.service.jsonplaceholder.PostService;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class PostControllerTest {

  long id = 57L;
  PostService postService;

  @Test
  @SneakyThrows
  @DisplayName("Get method works correctly")
  void get() {
    assertThat(postService.all())
        .isNotNull()
        .isNotEmpty()
        .hasSize(100);
  }

  @Test
  @SneakyThrows
  @DisplayName("Get one post method works correctly")
  void getOnePostMethodWorksCorrectlyTest() {

    val idCondition = new Condition<Post>(post -> post.getId() == id, "id is equals");
    val bodyCondition = new Condition<Post>(post -> post.getBody().equals(""), "body is equals");

    assertThat(postService.findById(id))
        .isNotNull()
        .satisfies(idCondition);
  }
}
