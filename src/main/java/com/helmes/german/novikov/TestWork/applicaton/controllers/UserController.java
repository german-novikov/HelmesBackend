package com.helmes.german.novikov.TestWork.applicaton.controllers;

import com.helmes.german.novikov.TestWork.applicaton.requests.UserSelectRequest;
import com.helmes.german.novikov.TestWork.domain.entity.UserSelect;
import com.helmes.german.novikov.TestWork.domain.repository.UserSelectRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Tag(name = "users")
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	@Autowired private UserSelectRepository repository;


	@PostMapping(path = "/user-select", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserSelect createUserSelect( @RequestBody @Valid UserSelectRequest userSelect){
		return repository.save(new UserSelect(userSelect.getName(), userSelect.getSectors(), userSelect.isAgreedWithTerms()));
	}

	@PutMapping(path = "/user-select/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserSelect updateUserSelect(@PathVariable("id") final long id, @RequestBody @Valid UserSelectRequest userSelect){
		var entity = repository.findById(id).orElseThrow(ResourceNotFoundException::new);

		entity.update(userSelect.getName(), userSelect.getSectors(), userSelect.isAgreedWithTerms());

		return repository.save(entity);
	}

}
