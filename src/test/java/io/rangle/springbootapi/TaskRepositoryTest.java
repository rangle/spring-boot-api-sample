package io.rangle.springbootapi;

import io.rangle.springbootapi.model.Task;
import io.rangle.springbootapi.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository repository;

    @Test
    public void whenGetById_thenReturnTask() {
        // given
        Task task = new Task();
        task.setDescription("Task Test");
        task = entityManager.persist(task);
        entityManager.flush();

        // when
        Task found = repository.findById(task.getId()).get();

        // then
        assertThat(found.getId())
                .isEqualTo(task.getId());
    }

}
