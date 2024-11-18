package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
