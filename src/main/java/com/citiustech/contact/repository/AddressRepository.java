package com.citiustech.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.contact.model.Address;
import com.citiustech.contact.model.Employee;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	public List<Address> findByEmployeeId(Long employeeID);
}