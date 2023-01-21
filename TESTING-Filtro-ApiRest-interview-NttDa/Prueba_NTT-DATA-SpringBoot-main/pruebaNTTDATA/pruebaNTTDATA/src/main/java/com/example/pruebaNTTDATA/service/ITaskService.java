package com.example.pruebaNTTDATA.service;

import com.example.pruebaNTTDATA.model.Task;

import java.util.List;

public interface ITaskService {
 public List<Task>listAllTasks();
 public Task saveTask(Task task);
 public Task findByIdTask(int id);
 public void deleteTask(int id);
 List<Task> searchTask(String filter) ;

}
