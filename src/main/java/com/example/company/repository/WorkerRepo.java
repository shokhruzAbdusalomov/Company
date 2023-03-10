package com.example.company.repository;

import com.example.company.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker,Long> {
}
