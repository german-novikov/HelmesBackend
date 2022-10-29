package com.helmes.german.novikov.TestWork.applicaton.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserSelectRequest {
	@NotEmpty(message = "Field can't be empty") private String name;

	@NotNull (message = "Field can't be empty")
	@Size(min = 1, max = 5)
	private List<Long> sectors;

	@AssertTrue private boolean agreedWithTerms;
}
