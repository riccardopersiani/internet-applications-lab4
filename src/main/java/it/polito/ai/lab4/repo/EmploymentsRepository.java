package it.polito.ai.lab4.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Employment;

public interface EmploymentsRepository extends CrudRepository<Employment, Long> {
	Set<Employment> findAll();
}
