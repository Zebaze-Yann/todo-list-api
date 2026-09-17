package com.springbootk48.todoList.services;

import com.springbootk48.todoList.entity.*;
import org.springframework.stereotype.Service;
import java.util.*;
import com.springbootk48.todoList.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTaskByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTaskDetails(Long id, String newTitle, Status newStatus, String newDescription) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("tache introuvable"));

        if (newTitle != null) {
            task.setTitle(newTitle);
        }
        if (newStatus != null) {
            task.setStatus(newStatus);
        }
        if (newDescription != null) {
            task.setDescription(newDescription);
        }

        return task;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : tâche introuvable avec l'ID " + id);
        }
        taskRepository.deleteById(id);
    }

}
