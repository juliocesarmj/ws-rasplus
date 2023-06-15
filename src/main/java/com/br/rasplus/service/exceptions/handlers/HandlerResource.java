package com.br.rasplus.service.exceptions.handlers;

import com.br.rasplus.dto.error.ErrorMapResponseDTO;
import com.br.rasplus.dto.error.ErrorResponseDTO;
import com.br.rasplus.service.exceptions.BadRequestException;
import com.br.rasplus.service.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerResource {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> notFoundHandler(NotFoundException n, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDTO.builder()
                        .message(n.getMessage())
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .path(req.getRequestURI())
                .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestHandler(BadRequestException n, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(n.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .path(req.getRequestURI())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMapResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException m, HttpServletRequest req) {
        Map<String, String> erros = new HashMap<>();

        m.getBindingResult()
                .getAllErrors()
                .forEach(err -> erros.put(((FieldError) err).getField(), err.getDefaultMessage()));
        var status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(ErrorMapResponseDTO.builder()
                        .message("Request error")
                        .httpStatus(status)
                        .statusCode(status.value())
                        .path(req.getRequestURI())
                        .errors(erros)
                .build());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handlerSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .path(req.getRequestURI())
                .build());
    }
}
