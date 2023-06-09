package com.br.rasplus.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMapResponseDTO {

    private String message;
    private HttpStatus httpStatus;
    private int statusCode;
    private String path;
    private Map<String, String> errors;
}
