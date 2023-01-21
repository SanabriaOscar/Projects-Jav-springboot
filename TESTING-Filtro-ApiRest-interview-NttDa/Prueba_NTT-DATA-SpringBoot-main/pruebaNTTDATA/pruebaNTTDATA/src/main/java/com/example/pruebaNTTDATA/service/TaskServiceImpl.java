package com.example.pruebaNTTDATA.service;

import com.example.pruebaNTTDATA.exceptions.DataNotFoundException;
import com.example.pruebaNTTDATA.model.Task;
import com.example.pruebaNTTDATA.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements  ITaskService{

    private TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task findByIdTask(int id) {
        Optional<Task> task=taskRepository.findById(id);
        if(task.isEmpty()) {
            throw new DataNotFoundException("Task not found", HttpStatus.NOT_FOUND);
        }else {
            return taskRepository.findById(id).get();
        }
    }

    @Override
    public void deleteTask(int id) {
     taskRepository.deleteById(id);
    }

    @Override
    public List<Task> searchTask(String filter) {

        if (filter != null) {
            return taskRepository.searchTask(filter);
        }
        return null;
    }



}
