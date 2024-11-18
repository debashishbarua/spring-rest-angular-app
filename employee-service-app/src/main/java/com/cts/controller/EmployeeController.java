package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/v1/employees")
	public ResponseEntity<List<Employee>> findAllV1() {
		log.info("START");
		List<Employee> findAll = service.findAll();
		log.debug("Eployees: {}", findAll);
		log.info("END");
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@GetMapping("/v1/employees/{id}")
	public ResponseEntity<Employee> findByIdV1(@PathVariable("id") int id) throws EmployeeNotFoundException {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping("/v1/employees")
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
		log.info("START");
		ResponseEntity<Employee> responseEntity;
		log.debug("Request Body:{} ",employee);
		responseEntity = new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
		log.info("END");
		return responseEntity;
	}

	@DeleteMapping("/v1/employees/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		service.deleteById(id);
		return new ResponseEntity<>("Employee Deteted With Id: " + id, HttpStatus.OK);
	}

	@PutMapping("/v1/employees/{id}")
	public Employee update(@PathVariable("id") int id, @RequestBody Employee employee) {
		return service.update(id, employee);
	}

}
