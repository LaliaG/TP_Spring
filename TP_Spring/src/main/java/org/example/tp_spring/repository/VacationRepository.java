package org.example.tp_spring.repository;

import org.example.tp_spring.entity.Vacation;
import org.springframework.data.repository.CrudRepository;

public interface VacationRepository extends CrudRepository<Vacation, Integer> {
}
