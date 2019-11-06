package com.glarimy.bank.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glarimy.bank.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findById(int id);
}
