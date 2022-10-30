package com.helmes.german.novikov.TestWork.applicaton.requests;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserSelectRequest {
	@NotEmpty(message = "Field can't be empty") private String name;

	@NotNull(message = "Field can't be empty")
	@Size(min = 1, max = 5, message="Sector should be selected, max selected 5")
	private List<Long> sectors;

	@AssertTrue(message = "Please agree to terms")
	@NotNull(message = "Field can't be empty")
	private boolean agreedWithTerms;
}
