package com.widneydev.cafe_social.handler;

import com.widneydev.cafe_social.exceptions.BadRequestException;
import com.widneydev.cafe_social.exceptions.BadRequestExceptionDetails;
import com.widneydev.cafe_social.exceptions.ExceptionDetails;
import com.widneydev.cafe_social.exceptions.ValidationExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

// vai ser usada sempre que acontecer uma exceção nas requisições da api
@ControllerAdvice // falando para o controle que essa é uma classe com as informações que ele precisa utilizar para exceções
public class RestExceptionHandler {

    // falando para os controllers que caso vc tenha uma exceção do tipo badrequest, utiliza-se esse exceptionhandler
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST
        );
    }

    // descobrindo qual a exeção que tá sendo lançada
    // com esse handler, a requisição do post vai ficar com todas as exceções customizadas
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ValidationExceptionDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldsMassage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Invalid Fields")
                        .details("Check the field(s) error")
                        .developerMessage(exception.getClass().getName())
                        .fields(fields)
                        .fieldMessage(fieldsMassage)
                .build(), HttpStatus.BAD_REQUEST
        );
    }



    // para exceções adversas que podem ocorrer na api é preciso sobrecarregar este handler
    protected ResponseEntity<Object> handleExceptionInternal
    (Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request){
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(statusCode)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(statusCode.value())
                .title(ex.getCause().getMessage())
                .details("Check the field(s) error")
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(exceptionDetails, headers, statusCode);
    }

}
