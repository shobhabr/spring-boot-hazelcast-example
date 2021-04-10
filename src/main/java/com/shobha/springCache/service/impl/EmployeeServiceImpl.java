package com.shobha.springCache.service.impl;

import java.util.List;

import com.shobha.springCache.model.Employee;
import com.shobha.springCache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shobha.springCache.dao.EmployeeDao;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	@Override
	@Cacheable()
	public List<Employee> getAllEmployees() {
		System.out.println("Employee Service Layer - Get All Employees");
		return employeeDao.getAllEmployees();

	}

	@Override
	public void getEmployeeById(String empId) {
		Employee employee = employeeDao.getEmployeeById(empId);
		System.out.println(employee);
	}
}