package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
	
	@Autowired
	private EmployeePayrollRepository payrollRepository;
	
	private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.stream()
				.filter(list -> list.getEmployeeId()==empId)
				.findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee not present"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(employeePayrollDTO);
		employeePayrollList.add(payrollData);
		log.debug("Emp data : "+payrollData.toString());
		return payrollRepository.save(payrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData=this.getEmployeePayrollDataById(empId);
		payrollData.setName(employeePayrollDTO.name);
		payrollData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(empId-1, payrollData);
		return payrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId-1);
		
	}

}
