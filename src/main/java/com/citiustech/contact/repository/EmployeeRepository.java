package com.citiustech.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.contact.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	//List<Employee> findByAdrPincode(String name);
}

/*
changes made on 19-9-2018
package com.citiustech.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.contact.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
