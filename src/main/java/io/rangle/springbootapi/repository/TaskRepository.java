package io.rangle.springbootapi.repository;

import io.rangle.springbootapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByDescriptionContaining(String text);
}
