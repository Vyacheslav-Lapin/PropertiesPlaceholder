package ru.vlapin.experiments.PropertiesPlaceholder.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.PropertiesPlaceholder.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
