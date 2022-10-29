package com.helmes.german.novikov.TestWork.applicaton.controllers;

import com.helmes.german.novikov.TestWork.domain.entity.Sector;
import com.helmes.german.novikov.TestWork.domain.repository.SectorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Tag(name = "sectors")
@RequestMapping("/sectors")
@AllArgsConstructor
public class SectorController {

	@Autowired
	private SectorRepository repository;

	@GetMapping(produces = "application/json")
	@Operation(responses = @ApiResponse( responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Sector.class) )) ))
	public List<Sector> getSectors(){
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}
