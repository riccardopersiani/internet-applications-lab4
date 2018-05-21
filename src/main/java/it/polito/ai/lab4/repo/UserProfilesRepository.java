package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.UserProfile;

public interface UserProfilesRepository extends CrudRepository<UserProfile, Long> {

}
