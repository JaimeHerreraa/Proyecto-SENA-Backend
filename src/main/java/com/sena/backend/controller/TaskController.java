package com.sena.backend.controller;

import com.sena.backend.model.Task;
import com.sena.backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") int id) {
        taskService.deleteTask(id);
    }

    @GetMapping(path = "pending")
    public List<Task> pendingTasks() {
        return taskService.pendingTasks();
    }

    @PutMapping("{taskId}")
    public void updateTaskState(@PathVariable("taskId") Integer id, @RequestBody Task taskDetails) {
        taskService.updateTask(id, taskDetails);
    }
}
