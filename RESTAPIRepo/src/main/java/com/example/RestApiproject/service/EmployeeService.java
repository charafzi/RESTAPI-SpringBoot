package com.example.RestApiproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestApiproject.bo.Employee;
import com.example.RestApiproject.dto.EmployeeDTO;
import com.example.RestApiproject.repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeServiceInterface{
	@Autowired
private EmployeeRepository employeerepository;
	@Autowired
	private EquipeService equipeService;

@Override
public List<EmployeeDTO> getAllEmployee() {
	return employeerepository.findAll().stream()
			.map(e->this.fromEmployee(e))
			.collect(Collectors.toList());
}

@Override
public EmployeeDTO createEmployee(EmployeeDTO employeedto) {
return this.fromEmployee(employeerepository.save(this.toEmployee(employeedto)));
}

@Override
public EmployeeDTO updateEmployee(int id, EmployeeDTO new_employeedto) {
	Optional<Employee> old_employee=employeerepository.findById(id);
	
	if(old_employee.isPresent()) {
		Employee updatable_employee=old_employee.get();
		
		updatable_employee.setNom(new_employeedto.getNom());
		updatable_employee.setPrenom(new_employeedto.getPrenom());
		updatable_employee.setEmail(new_employeedto.getEmail());
		updatable_employee.setAdresse(new_employeedto.getAdresse());
		updatable_employee.setSalaire(new_employeedto.getSalaire());
		return this.fromEmployee(employeerepository.save(updatable_employee));
	}
	else
		throw new RuntimeException("Employee not found");
}

@Override
public void deleteEmployee(int id) {
	
	 employeerepository.deleteById(id);
}

@Override
public EmployeeDTO getEmployee(int id) {

	Optional<Employee> employee=employeerepository.findById(id);
	if(employee.isPresent())
	return this.fromEmployee(employee.get());
	else
		return null;
}
	private Employee toEmployee(EmployeeDTO employeedto) {
		
		return Employee.builder()
		.id(employeedto.getId())
		.prenom(employeedto.getPrenom())
		.nom(employeedto.getNom())
		.email(employeedto.getEmail())
		.adresse(employeedto.getAdresse())
		.salaire(employeedto.getSalaire())
		.equipe(equipeService.toEquipe(employeedto.getEquipe()))

				.build();
		
		
	}
private EmployeeDTO fromEmployee(Employee employee) {
		
	return	EmployeeDTO.builder()
			.id(employee.getId())
			.prenom(employee.getPrenom())
			.nom(employee.getNom())
			.email(employee.getEmail())
			.adresse(employee.getAdresse())
			.salaire(employee.getSalaire())
			.equipe(equipeService.fromEquipe(employee.getEquipe()))
			.build();
	}
}
