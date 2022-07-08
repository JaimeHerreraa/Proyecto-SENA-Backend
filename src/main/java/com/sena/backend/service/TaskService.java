package com.sena.backend.service;

import com.sena.backend.model.Task;
import com.sena.backend.repository.ITaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    private final ITaskRepository ITaskRepository;

    public TaskService(ITaskRepository ITaskRepository) {
        this.ITaskRepository = ITaskRepository;
    }

    public void addTask(Task task) {
        ITaskRepository.save(task);
    }

    public List<Task> getTasks() {
        return ITaskRepository.findAll();
    }

    public void deleteTask(int id) {
        boolean exists = ITaskRepository.existsById(id);
        if (exists) {
            ITaskRepository.deleteById(id);
        } else {
            throw new IllegalStateException("El pedido que se intenta borrar no se encuentra en la base de datos");
        }
    }

    public List<Task> pendingTasks() {
        return ITaskRepository.findTasksByState();
    }

    public void updateTask(Integer id, Task taskDetails) {
        Task task = ITaskRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El pedido con el id " + id + "no se encuentra en la base de datos"));

        task.setState(taskDetails.getState());

        ITaskRepository.save(task);
    }
}
