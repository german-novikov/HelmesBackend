package com.helmes.german.novikov.TestWork.applicaton.controllers;

import com.helmes.german.novikov.TestWork.applicaton.requests.UserSelectRequest;
import com.helmes.german.novikov.TestWork.domain.entity.UserSelect;
import com.helmes.german.novikov.TestWork.domain.repository.UserSelectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTests {

	@Mock
	private UserSelectRepository userSelectRepository;
	private UserController controller;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		controller = new UserController(userSelectRepository);
	}

	@Test
	void create_will_return_new() {

		var request = new UserSelectRequest(UUID.randomUUID().toString(), List.of(1l, 2L), true);

		var expected = new UserSelect(1L, request.getName(), request.getSectors(), request.isAgreedWithTerms());
		when(userSelectRepository.save(any())).thenReturn(expected);


		var actual = controller.createUserSelect(request);

		assertSame(expected, actual);
	}

	@Test
	void update_will_return_updated() {

		var request = new UserSelectRequest(UUID.randomUUID().toString(), List.of(1l, 2L), true);
		var id = 1L;
		var valueInDb = new UserSelect(id, UUID.randomUUID().toString(), List.of(), false);
		when(userSelectRepository.findById(id)).thenReturn(Optional.of(valueInDb));

		controller.updateUserSelect(id, request);

		verify(userSelectRepository).save(argThat(data -> data.getName().equals(request.getName())
				&& data.getSectors().equals(request.getSectors())
				&& data.isAgreedWithTerms() == request.isAgreedWithTerms()
		));

	}

}