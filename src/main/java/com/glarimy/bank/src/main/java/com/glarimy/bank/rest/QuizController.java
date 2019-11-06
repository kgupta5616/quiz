package com.glarimy.bank.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.glarimy.bank.api.IEmployee;
import com.glarimy.bank.domain.Employee;

@RestController
public class QuizController {

	@Autowired
	private IEmployee iEmployee;

	@RequestMapping(path = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Employee> addNewAccount(@RequestBody Employee employee, UriComponentsBuilder builder) {
		employee = iEmployee.add(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> doTransaction(@PathVariable("id") int number, UriComponentsBuilder builder) {
		return new ResponseEntity<Employee>(iEmployee.getEmployee(number), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/employee/{id}")
	public ResponseEntity<String> history(@PathVariable("id") int number, UriComponentsBuilder builder) {
		boolean isDeleted = iEmployee.deleteEmployee(number);
		String delete;
		if(isDeleted) {
			delete = "Record deleted";
		} else {
			delete = "Record not deleted";
		}
		
		return new ResponseEntity<String>(delete, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/employee/{id}")
	public ResponseEntity<Employee> find(@RequestBody Employee id, UriComponentsBuilder builder) {
		return new ResponseEntity<Employee>(iEmployee.updateEmployee(id), HttpStatus.OK);
	}

}
