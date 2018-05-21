package it.polito.ai.lab4.business.services.authentication;

import it.polito.ai.lab4.repo.entities.User;

public interface CurrentUserService {

	public User getCurrentUser();
}
