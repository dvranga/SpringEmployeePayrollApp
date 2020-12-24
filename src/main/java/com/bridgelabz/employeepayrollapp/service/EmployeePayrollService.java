package com.bridgelabz.employeepayrollapp.service;

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
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return payrollRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return payrollRepository.findById(empId)
								.orElseThrow(() -> new EmployeePayrollException("Employee with employee id : "+empId+" does not exists "));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(employeePayrollDTO);
		log.debug("Emp data : "+payrollData.toString());
		return payrollRepository.save(payrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData=this.getEmployeePayrollDataById(empId);
		payrollData.updateEmployeePayrollData(employeePayrollDTO);
		return payrollRepository.save(payrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData employeePayrollDataById = this.getEmployeePayrollDataById(empId);
		payrollRepository.delete(employeePayrollDataById);
		
	}

}
