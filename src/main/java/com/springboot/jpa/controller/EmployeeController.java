package com.springboot.jpa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.entity.Employee;
import com.springboot.jpa.service.EmployeeService;

@RestController
public class EmployeeController 
{
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployees")
	public List<Employee> saveEmployee(@RequestBody List<Employee> employeeList)
	{
		
		return employeeService.saveEmployeeData(employeeList);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployees() 
	{
		return employeeService.getEmployees();
	}
	
	@GetMapping("/getEmployeeById/{empId}")
	public Employee getEmployeeById(@PathVariable long empId)
	{
		return employeeService.getEmployeeById(empId);
	}
	
	@DeleteMapping("/deleteEmployeeByDesignation/{designation}")
	public List<Employee> deleteEmployeeByDesgination(@PathVariable String designation)
	{
		return employeeService.deleteEmployeeByDesgination(designation);
	}
	
	@DeleteMapping("/employees")
	public String deleteAllEmployee()
	{
		employeeService.deleteAllEmployees();
		return "all employee have been deleted";
	}
	
	@GetMapping("/getEmployeeByDesignation/{designation}")
	public Employee getEmployeeByDesgination(@PathVariable String designation)
	{
		return employeeService.getEmployeeByDesgination(designation);
	}
	
	// Query 
	@GetMapping("/getEmployees")
	public List<Employee> getEmployee()
	{
		return employeeService.getEmployeeData();
	}
	
	@GetMapping("/findEmployeeByDesignationAndActiveData/{activeState}/{designationList}")
	public List<Employee> findEmployeeByDesignationAndActiveData(@PathVariable boolean activeState, @PathVariable List<String> designationList)
	{
		
		return employeeService.findEmployeeByDesignationAndActiveData(activeState,designationList);
	}
}
