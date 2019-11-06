package com.glarimy.bank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.glarimy.bank.api.IEmployee;
import com.glarimy.bank.data.EmployeeRepository;
import com.glarimy.bank.domain.Employee;
import com.glarimy.bank.exceptions.EmployeeException;

@Service
@EnableTransactionManagement
public class QuizService implements IEmployee {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	@Transactional
	public Employee add(Employee employee) throws EmployeeException {
		repo.save(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(int number) throws EmployeeException {
		return repo.findOne(number);
	}

	@Override
	public boolean deleteEmployee(int number) throws EmployeeException {
		Employee emp = repo.findOne(number);
		if(null != emp) {
			repo.delete(emp);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		Employee emp = repo.findOne(employee.getId());
		if(null == emp) {
			return null;
		} else {
			repo.save(employee);
		}
		return employee;
	}

}
