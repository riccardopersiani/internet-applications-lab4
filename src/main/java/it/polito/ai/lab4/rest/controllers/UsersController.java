package it.polito.ai.lab4.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.business.services.users.UsersService;
import it.polito.ai.lab4.rest.resources.AnonymizedUser;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/rest/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public PagedResources<Resource<AnonymizedUser>> usersReturn(Pageable pageable,
			PagedResourcesAssembler<AnonymizedUser> assembler) {
		Page<AnonymizedUser> anonimizedUsers = usersService.findAllUsers(pageable).map(u -> new AnonymizedUser(u));
		return assembler.toResource(anonimizedUsers);
	}
}