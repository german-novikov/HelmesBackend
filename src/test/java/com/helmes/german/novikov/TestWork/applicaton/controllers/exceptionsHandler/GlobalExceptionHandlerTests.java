package com.helmes.german.novikov.TestWork.applicaton.controllers.exceptionsHandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTests {
	GlobalExceptionHandler handler = new GlobalExceptionHandler();

	@Test
	void success_handle_run_time_exception() {
		var result = handler.handleRunTimeException(Mockito.mock(RuntimeException.class));
		assertEquals("Internal server error. Please try again. If error persists please contact support.", result.getGeneric()[0].getMessage());
	}

	@Test
	void success_handle_method_argument_not_valid_exception() {
		var bindResult = Mockito.mock(BindingResult.class);
		var exception = new MethodArgumentNotValidException(null, bindResult);
		var fieldError = new FieldError("TestObject", "TestField", "DefaultMessage");
		Mockito.when(bindResult.getFieldErrors()).thenReturn(List.of(fieldError));
		var result = handler.handleMethodArgumentNotValidException(exception);
		Assertions.assertNotNull(result.getFields().get("TestField"));
	}
}