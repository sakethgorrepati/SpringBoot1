package com.test.testapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.testapp.model.Employee;

@RestController
@RequestMapping(path = "/test" , produces = MediaType.APPLICATION_JSON_VALUE)
public class TestAppController {

	@GetMapping(path="/list")
	public @ResponseBody List<Employee> list() {
		
		return getStaticEmployeeData();
	}



	private List<Employee> getStaticEmployeeData() {
		
		List<Employee> employeeList	=	new ArrayList<Employee>();
		
		Employee employee1	=	new Employee();
		
		employee1.setName("Saketh");
		employee1.setId(1000l);
		employee1.setSalary(1000.25d);
		
		Employee employee2	=	new Employee();
		
		employee2.setName("Arun");
		employee2.setId(2000l);
		employee2.setSalary(2000.25d);
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		return employeeList;
	}
	
	
	
	@GetMapping
	public @ResponseBody ResponseEntity<Employee> getEmployee(@PathVariable(value ="id") Long id) {
		
		List<Employee> employeeList = getStaticEmployeeData();
		
		Optional<Employee> employee	=	employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
		
		if(employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.ACCEPTED);
		} 
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	/*@GetMapping
	public Object create(Object ) {
		// TODO Auto-generated method stub

	}*/
	
}
