package com.example.springrecipe.repositories;

import com.example.springrecipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findUnitOfMeasureByDescription(String description);
}
