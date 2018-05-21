package it.polito.ai.lab4.business.services.users;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.polito.ai.lab4.repo.UsersRepository;
import it.polito.ai.lab4.repo.entities.User;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public Page<User> findAllUsers(Pageable pageable) {
		return usersRepository.findAll(pageable);
	}
}
