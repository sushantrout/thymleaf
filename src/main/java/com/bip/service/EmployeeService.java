package com.bip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bip.entity.Employee;
import com.bip.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}
	public Page<Employee> listByPage(int pageNo, int noOfResult, String columnName) {
		Pageable pageable = PageRequest.of(pageNo, noOfResult, Sort.by("empId"));
		Page<Employee> findAll = employeeRepo.findAll(pageable);
		int number = findAll.getNumber();
		System.out.println(number);
		System.out.println(findAll.getContent());
		System.out.println(findAll.getTotalElements());
		return findAll;
	}

	public Employee findOne(Long id) {
		return employeeRepo.findById(id).get();
	}
}
