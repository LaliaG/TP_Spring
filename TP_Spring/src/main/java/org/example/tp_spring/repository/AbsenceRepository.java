package org.example.tp_spring.repository;

import org.example.tp_spring.entity.Absence;
import org.springframework.data.repository.CrudRepository;

public interface AbsenceRepository extends CrudRepository<Absence, Integer> {
}
