package com.citiustech.contact.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.contact.model.Address;
import com.citiustech.contact.model.Employee;
import com.citiustech.contact.service.AddressService;
import com.citiustech.contact.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	
	@Autowired
	AddressService adrService;
	@CrossOrigin
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}
	@CrossOrigin
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp,@RequestHeader HttpHeaders headers ) {
		//System.out.println("headers values are"+headers.getContentLength());
		return employeeService.save(emp);
	}
	
	
	//@PutMapping("/employees/{id}")
	@CrossOrigin
	@RequestMapping(value="/employees/{id}" , method=RequestMethod.PUT,
					consumes ={MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE },
							produces = { "application/json", "application/xml" })
	public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable(value="id") Long empid, @RequestBody Employee empDetails){

		empDetails.setId(empid);
		Employee updateEmployee=employeeService.save(empDetails);
		return new ResponseEntity(updateEmployee,HttpStatus.CREATED);
		
		
	}
	
	
	@CrossOrigin
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeService.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.delete(emp);
		
		return ResponseEntity.ok().build();	
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeService.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	

}



/*
commented on 19-9-2018

package com.citiustech.contact.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.citiustech.contact.model.Employee;
import com.citiustech.contact.service.EmployeeService;

@RestController

public class EmployeeController {
	

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp ) {
		return employeeService.save(emp);
	}
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable(value="id") Long empid, @RequestBody Employee empDetails){
		Employee updateEmployee=employeeService.save(empDetails);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeService.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.delete(emp);
		
		return ResponseEntity.ok().build();	
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeService.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	

}


/*public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
//	 to save an employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	//get employee by empid
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	//update an employee by empid
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	//Delete an employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
*/
