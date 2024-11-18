package com.cts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.DepartmentRepository;
import com.cts.exception.DepartmentNotFoundException;
import com.cts.model.Department;
import com.cts.service.DepartmentService;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> findAll() {

		return departmentRepository.findAll();
	}

	@Override
	public Department findById(int id) {
		Optional<Department> findById = departmentRepository.findById(id);
		if (findById.isEmpty()) {
			throw new DepartmentNotFoundException("Department Not Found Exxception with id: " + id);
		}
		return findById.get();

	}

	//@Transactional
	@Override
	public Department create(Department department) {

		return departmentRepository.save(department);
	}

}
