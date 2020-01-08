package io.rangle.springbootapi.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GenericResponse {
    private String message;
    private LocalDateTime timestamp;

    public GenericResponse(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
