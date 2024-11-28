package com.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.springboot.jpa.entity.Employee;
import com.springboot.jpa.repository.EmployeeRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> saveEmployeeData(List<Employee> employeeList) 
	{
		return employeeRepository.saveAll(employeeList);
	}

	public List<Employee> getEmployees() 
	{	
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(long empId) 
	{
		
		return employeeRepository.findByEmpId(empId);
	}

	public List<Employee> deleteEmployeeByDesgination(String designation) 
	{
		
		return employeeRepository.deleteByDesignation(designation);
	}

	public Employee getEmployeeByDesgination(String designation) 
	{
		
		return employeeRepository.findTopByDesignationOrderBySalaryDesc(designation);
	}

	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	public List<Employee> getEmployeeData() 
	{
		
		return employeeRepository.findAllEmployeeQuery();
	}

	public List<Employee> findEmployeeByDesignationAndActiveData(boolean activeState, List<String> designationList) {
		
		return employeeRepository.findEmployeeByDesignationAndActiveQuery(activeState, designationList);
	}
	
	
	
}
