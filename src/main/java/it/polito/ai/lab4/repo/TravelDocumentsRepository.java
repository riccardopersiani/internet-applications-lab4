package it.polito.ai.lab4.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.TravelDocument;

public interface TravelDocumentsRepository extends CrudRepository<TravelDocument, Long> {
	Set<TravelDocument> findAll();
}
