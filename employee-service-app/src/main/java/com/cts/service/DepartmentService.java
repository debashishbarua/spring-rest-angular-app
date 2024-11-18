package com.cts.service;

import java.util.List;

import com.cts.model.Department;

public interface DepartmentService {

	List<Department> findAll();

	Department findById(int id);

	Department create(Department department);

}
