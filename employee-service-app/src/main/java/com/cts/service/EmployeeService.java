package com.cts.service;

import java.util.List;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;

public interface EmployeeService {
	
	public Employee create(Employee employee);
	
	public List<Employee> findAll();
	
	public Employee findById(int id)throws EmployeeNotFoundException;

	public void deleteById(int id) throws EmployeeNotFoundException;

	public Employee update(int id, Employee employee);

}
