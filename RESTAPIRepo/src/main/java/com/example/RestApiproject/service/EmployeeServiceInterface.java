package com.example.RestApiproject.service;

import java.util.List;

import com.example.RestApiproject.dto.EmployeeDTO;

public interface EmployeeServiceInterface {
 List<EmployeeDTO> getAllEmployee();
 EmployeeDTO createEmployee(EmployeeDTO employeedto);
 EmployeeDTO updateEmployee(int id,EmployeeDTO new_employeedto);
 void deleteEmployee(int id); 
 EmployeeDTO getEmployee(int id);
}
