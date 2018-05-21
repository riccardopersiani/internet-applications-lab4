package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Image;

public interface ImagesRepository extends CrudRepository<Image, Long> {

}
