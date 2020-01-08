package io.rangle.springbootapi.controller;

import io.rangle.springbootapi.controller.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/healthCheck")
public class HealthController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse getHealthStatus() {
        return new GenericResponse("OK");
    }
}
