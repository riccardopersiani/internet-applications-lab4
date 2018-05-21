package it.polito.ai.lab4.business.services.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.polito.ai.lab4.repo.entities.User;

public interface UsersService {

	/**
	 * Gives access to the repository of users
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<User> findAllUsers(Pageable pageable);
}
