package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Department;
import com.cts.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping("/v1/departments")
	public ResponseEntity<List<Department>> findAllV1() {
		log.info("START");
		List<Department> findAll = departmentService.findAll();
		log.debug("Departments: {}", findAll);
		log.info("END");
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@GetMapping("/v1/departments/{id}")
	public ResponseEntity<Department> findByIdV1(@PathVariable("id") int id) {
		log.info("START");
		Department findById = departmentService.findById(id);
		log.debug("Department: {}", findById);
		log.info("END");
		return new ResponseEntity<>(findById	, HttpStatus.OK);
	}
	
	
	@PostMapping("/v1/departments")
	public ResponseEntity<Department> createV1(@RequestBody Department department	) {
		log.info("START");
		Department create=departmentService.create(department);		
		log.debug("Department: {}", create);
		log.info("END");
		return new ResponseEntity<>(create	, HttpStatus.OK);
	}
}
