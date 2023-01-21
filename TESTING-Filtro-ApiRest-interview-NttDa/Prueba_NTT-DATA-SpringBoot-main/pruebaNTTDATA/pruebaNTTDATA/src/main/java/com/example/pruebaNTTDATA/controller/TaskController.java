package com.example.pruebaNTTDATA.controller;

import com.example.pruebaNTTDATA.exceptions.DataNotFoundException;
import com.example.pruebaNTTDATA.model.Task;
import com.example.pruebaNTTDATA.repository.TaskRepository;
import com.example.pruebaNTTDATA.service.TaskServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private TaskServiceImpl taskService;
    private TaskRepository taskRepository;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> listAllTaskC(){
        return taskService.listAllTasks();
    }


    @GetMapping("/searchTask")
    public ResponseEntity<?> searchUserC(@Param("filter") String filter) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(taskService.searchTask(filter));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""
                    +e.getMessage()+"\"}"));
        }
    }
    @PostMapping("/tasks/add")
    public String saveTaskC(@RequestBody Task task){
        Optional<Task> savedTask = Optional.ofNullable(taskService.findByIdTask(task.getId()));
        if(savedTask.isPresent()){
            throw new DataNotFoundException("Task already exist:" + task.getId());
        }
        taskService.saveTask(task);
        return "user saved sussesfull";
    }

    @GetMapping("/tasks/{id}")
    public Task listTaskByIdC(@PathVariable int id) {
        return taskService.findByIdTask(id);
    }
    @PutMapping("/tasks/edit/{id}")
    public Task updateTaskByIdC(@PathVariable int id, @RequestBody Task task) {
        Task taskUpdate=taskService.findByIdTask(id);
        taskUpdate.setName(task.getName());
        taskUpdate.setDate(task.getDate());
        taskService.saveTask(taskUpdate);
        return taskUpdate;
    }
    @DeleteMapping("/tasks/delete/{id}")
    public String deleteTaskC(@PathVariable int id){
        taskService.deleteTask(id);
        return "Task deleted sussesfull";
    }

}
