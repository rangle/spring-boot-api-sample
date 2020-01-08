package io.rangle.springbootapi.service;

import io.rangle.springbootapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Optional<Task> getById(Integer id);

    List<Task> getAll();

    List<Task> getByDescriptionContaining(String text);

    Task add(Task task);

    Task update(Task task);

    Boolean delete(Integer id);

}
