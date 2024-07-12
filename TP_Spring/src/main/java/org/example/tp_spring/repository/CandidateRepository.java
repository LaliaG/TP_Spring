package org.example.tp_spring.repository;

import org.example.tp_spring.entity.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

}
