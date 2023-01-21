package com.example.pruebaNTTDATA;

import com.example.pruebaNTTDATA.model.Task;
import com.example.pruebaNTTDATA.repository.TaskRepository;
import com.example.pruebaNTTDATA.service.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepositotyTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;
    @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks( this);
    }

    @Test
   // @Rollback(false)
    public void saveTaskTest(){
        Task task =new Task(4,"fixed a cumputer");
        when(taskRepository.save(ArgumentMatchers.any(Task.class))).thenReturn(task);
        Task created = taskService.saveTask(task);
        assertThat(created.getName()).isSameAs(task.getName());
        verify(taskRepository).save(task);
    }

    @Test
    public void ListAllTasks() {
        List<Task> tasks = new ArrayList();
        tasks.add(new Task());
        given(taskRepository.findAll()).willReturn(tasks);
        List<Task> expected = taskService.listAllTasks();
        assertEquals(expected, tasks);
        verify(taskRepository).findAll();
    }

    @Test
    public void listTaskBYID() {
        Task task = new Task(4, "fixing pc");

        when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));
        Task expected = taskService.findByIdTask(task.getId());
        assertThat(expected).isSameAs(task);
        verify(taskRepository).findById(task.getId());
    }
    @Test
    public void deleteTaskTest(){
        Task task =new Task(4,"fixed a cumputer");
        when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));
        taskService.deleteTask(task.getId());
        verify(taskRepository).deleteById(task.getId());
    }

}
