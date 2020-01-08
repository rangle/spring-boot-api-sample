package io.rangle.springbootapi.service;

import io.rangle.springbootapi.model.Task;
import io.rangle.springbootapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public Optional<Task> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Task> getByDescriptionContaining(String text) {
        return repository.findByDescriptionContaining(text);
    }

    @Override
    public Task add(Task task) {
        repository.save(task);
        return task;
    }

    @Override
    public Task update(Task task) {
        Optional<Task> optionalTask = getById(task.getId());
        if(optionalTask.isPresent()) {
            Task taskToUpdate = optionalTask.get();
            taskToUpdate.setDescription(task.getDescription());
            repository.save(taskToUpdate);
            return taskToUpdate;
        } else {
            return null;
        }
    }

    @Override
    public Boolean delete(Integer id) {
        Optional<Task> optionalTask = getById(id);
        if(optionalTask.isPresent()) {
            Task task = optionalTask.get();
            repository.delete(task);
            return true;
        } else {
            return false;
        }
    }
}
