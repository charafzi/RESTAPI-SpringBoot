package com.example.RestApiproject.controller;
import com.example.RestApiproject.dto.*;
import com.example.RestApiproject.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	
@GetMapping("/employees")	
public List<EmployeeDTO> getAllEmployees() {
	return employeeservice.getAllEmployee();
}

@GetMapping("/employee/{id}")
public EmployeeDTO getEmployee(@PathVariable(name="id") int id) {
	return employeeservice.getEmployee(id);
}

@PostMapping("/employee")
public EmployeeDTO createEmployee(@RequestBody EmployeeDTO empdto) {
	return employeeservice.createEmployee(empdto);
	
}
@PutMapping("/employee/{id}")
public EmployeeDTO updateEmployee(@PathVariable(name="id") int id,@RequestBody EmployeeDTO empdto) {
	return employeeservice.updateEmployee(id, empdto);
}

@DeleteMapping("/employee/{id}")
public void deleteEmployee(@PathVariable(name = "id") int id) {
	
	 employeeservice.deleteEmployee(id);
}
}
