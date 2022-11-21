package com.practise.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practise.model.Employee;
import com.practise.repository.EmployeeRepository;
import com.practise.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeeList() {
		
		return (List<Employee>)employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
				
		Employee emp = employeeRepository.getById(id);
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setMobile(employee.getMobile());

		
		
		return employeeRepository.save(emp);
	}
	

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}
	
//	@Override
//	public List<MobilePhoneList> getAllMobilePhoneList(int page) {
//		int size = 2;
//		Pageable pagable = PageRequest.of(page,size);
//		return  mobilePhonelistRepository.findAll(pagable).toList();
//				
//		
//	}
	
	@Override
	public List<Employee> getEmployeeList(int page){
		int size =5;
		Pageable pageable =PageRequest.of(page, size);
		return employeeRepository.findAll(pageable).toList();
	}
	


}
