package com.sena.backend.repository;

import com.sena.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM task WHERE state='pendiente'", nativeQuery = true)
    List<Task> findTasksByState();
}
