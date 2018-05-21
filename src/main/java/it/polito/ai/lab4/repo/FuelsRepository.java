package it.polito.ai.lab4.repo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Fuel;

public interface FuelsRepository extends CrudRepository<Fuel, Long> {
	Set<Fuel> findAll();
}
