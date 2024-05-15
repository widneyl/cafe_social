package com.widneydev.cafe_social.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
// handler para validação de campos
public class ValidationExceptionDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldMessage;
}
