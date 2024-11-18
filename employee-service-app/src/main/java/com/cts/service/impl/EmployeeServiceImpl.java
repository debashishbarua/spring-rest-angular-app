package com.cts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.EmployeeRepository;
import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee create(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> findAll() {

		return repository.findAll();
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException{
		Optional<Employee> optional=repository.findById(id);
		if(optional.isEmpty()) {
			throw new EmployeeNotFoundException("Employee Not Foun With id: " +id);
		}
		return optional.get();
	}
	
	@Override
	public void deleteById(int id) throws EmployeeNotFoundException{
		findById(id);
		
		repository.deleteById(id);
	}

	@Override
	public Employee update(int id, Employee newEmployee) throws EmployeeNotFoundException{
		Employee  employee=findById(id);
		employee.setFirstName(newEmployee.getFirstName());
		employee.setLastName(newEmployee.getLastName());
		employee.setAddress(newEmployee.getAddress());
		employee.setDepartment(newEmployee.getDepartment());
		return repository.save(employee);
	}

}
