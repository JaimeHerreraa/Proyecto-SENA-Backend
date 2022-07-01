package com.sena.backend.service;

import com.sena.backend.model.Task;
import com.sena.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(int id) {
        boolean exists = taskRepository.existsById(id);
        if (exists) {
            taskRepository.deleteById(id);
        } else {
            throw new IllegalStateException("El pedido que se intenta borrar no se encuentra en la base de datos");
        }
    }

    public List<Task> pendingTasks() {
        return taskRepository.findTasksByState();
    }

    public void updateTask(Integer id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El pedido con el id " + id + "no se encuentra en la base de datos"));

        task.setState(taskDetails.getState());

        taskRepository.save(task);
    }
}
