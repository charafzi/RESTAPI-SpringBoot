package com.example.RestApiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RestApiproject.bo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
