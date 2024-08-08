package com.example.TestTask.repository;

import com.example.TestTask.entity.Computer;
import com.example.TestTask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ComputerRepository extends JpaRepository<Computer, UUID> {
}
