package com.practise.controller;

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

import com.practise.exception.EmployeeNotFoundException;
import com.practise.model.Employee;
import com.practise.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4300")  
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/employees/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/employees/view")
	public List<Employee> getEmployeeList(){
		return employeeService.getEmployeeList();
	}
	
	@PutMapping("/employees/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id" )long id) {
		return employeeService.updateEmployee(employee, id);	
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id" )long id) {
		employeeService.deleteEmployee(id);
		return "deleted";
	}
	

	 
	@GetMapping("/{listid}")
	public ResponseEntity<?> getEmployees(@PathVariable(value = "listid") int id) throws EmployeeNotFoundException{
		return new ResponseEntity<>(employeeService.getEmployeeList(id), HttpStatus.OK);
	}

}
