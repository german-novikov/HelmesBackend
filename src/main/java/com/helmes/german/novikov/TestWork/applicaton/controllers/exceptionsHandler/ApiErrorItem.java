package com.helmes.german.novikov.TestWork.applicaton.controllers.exceptionsHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiErrorItem {
    private String message;
    private String[] args = new String[0];

    public ApiErrorItem(String message) {
        this.message = message;
    }
}