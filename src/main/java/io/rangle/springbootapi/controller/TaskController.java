package io.rangle.springbootapi.controller;

import io.rangle.springbootapi.model.Task;
import io.rangle.springbootapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAll(@RequestParam(value = "search") Optional<String> search) {
        if(search.isPresent()) {
            return service.getByDescriptionContaining(search.get());
        } else {
            return service.getAll();
        }
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getById(@PathVariable(value = "id") Integer id) {
        Optional<Task> optionalTask = service.getById(id);
        if(optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/task")
    public ResponseEntity<Task> add(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(service.add(task));
    }

    @PutMapping("/task")
    public ResponseEntity<Task> update(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(service.update(task));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        if(service.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
