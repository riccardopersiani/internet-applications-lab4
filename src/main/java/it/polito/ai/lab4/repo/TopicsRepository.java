package it.polito.ai.lab4.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Topic;

public interface TopicsRepository extends CrudRepository<Topic, Long> {
	public Set<Topic> findAll();
	public Topic findByValue(String value);
}
