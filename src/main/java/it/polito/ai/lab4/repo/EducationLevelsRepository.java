package it.polito.ai.lab4.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.EducationLevel;

public interface EducationLevelsRepository extends CrudRepository<EducationLevel, Long> {
	Set<EducationLevel> findAll();
}
