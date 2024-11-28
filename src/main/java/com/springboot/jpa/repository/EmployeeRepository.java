package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByEmpId(long id);

	List<Employee> deleteByDesignation(String designation);

	Employee findTopByDesignationOrderBySalaryDesc(String designation);
	
	
	// create query
	@Query("select e from Employee e")
	List<Employee> findAllEmployeeQuery();
	
	
	@Query("select e from Employee e where e.active=:activeState and e.designation in :designationList")
	List<Employee> findEmployeeByDesignationAndActiveQuery(@Param("activeState") boolean activeState,
														   @Param("designationList") List<String> designationList);
}
