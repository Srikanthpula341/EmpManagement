package com.practise.service;

import java.util.List;

import com.practise.model.Employee;


public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getEmployeeList();
	
	public Employee updateEmployee(Employee employee,long id);
	
	public void deleteEmployee(long id);

	public List<Employee> getEmployeeList(int page);

}
