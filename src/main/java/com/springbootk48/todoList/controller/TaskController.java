package com.springbootk48.todoList.controller;

import java.util.List;

import com.springbootk48.todoList.services.TaskService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.springbootk48.todoList.entity.*;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(@RequestParam(required = false) Status status) {
        if (status != null) {
            return taskService.getTaskByStatus(status);
        }

        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestParam(required = false) String title,
            @RequestParam(required = false) String description, @RequestParam(required = false) Status status) {
        return taskService.updateTaskDetails(id, title, status, description);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
