package com.practise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
