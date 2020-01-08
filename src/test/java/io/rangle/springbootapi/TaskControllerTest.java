package io.rangle.springbootapi;

import io.rangle.springbootapi.controller.TaskController;
import io.rangle.springbootapi.model.Task;
import io.rangle.springbootapi.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService service;

    @Test
    public void givenTasks_whenGetAll_thenReturnJsonArray()
            throws Exception {

        Task task = new Task();
        task.setId(1);
        task.setDescription("Test task");

        List<Task> tasks = Arrays.asList(task);

        given(service.getAll()).willReturn(tasks);

        mvc.perform(get("/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].description", is(task.getDescription())));
    }
}
