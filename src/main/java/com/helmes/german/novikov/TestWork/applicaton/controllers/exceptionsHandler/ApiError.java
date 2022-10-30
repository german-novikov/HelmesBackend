package com.helmes.german.novikov.TestWork.applicaton.controllers.exceptionsHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiError {
    private ApiErrorItem[] generic = new ApiErrorItem[0];
    private Map<String, ApiErrorItem[]> fields = new HashMap<>();
    private String errorMessageKey;

    public ApiError(String... generic) {
        this.generic = Arrays.asList(generic).stream().map(ApiErrorItem::new).toArray(ApiErrorItem[]::new);
    }

    public ApiError(String errorMessageKey, String generic) {
        this(generic);
        this.errorMessageKey = errorMessageKey;
    }

    public ApiError(ApiErrorItem... generic) {
        this.generic = generic;
    }

    public ApiError(Map<String, ApiErrorItem[]> fields) {
        this.fields = fields;
    }
}