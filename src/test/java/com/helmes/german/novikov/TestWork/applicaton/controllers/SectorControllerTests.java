package com.helmes.german.novikov.TestWork.applicaton.controllers;

import com.helmes.german.novikov.TestWork.domain.entity.Sector;
import com.helmes.german.novikov.TestWork.domain.repository.SectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

class SectorControllerTests {
	@Mock
	private SectorRepository sectorRepository;
	private SectorController controller;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		controller = new SectorController(sectorRepository);
	}

	@Test
	void return_list_of_sectors() {
		var expected1 = new Sector(1L, UUID.randomUUID().toString(), 0);
		var expected2 = new Sector(1L, UUID.randomUUID().toString(), 0);
		var expectedList = List.of(expected1, expected2);
		when(sectorRepository.findAll()).thenReturn(expectedList);

		var actual = controller.getSectors();

		assertSame(expectedList.get(0), actual.get(0));
		assertSame(expectedList.get(1), actual.get(1));
	}
}