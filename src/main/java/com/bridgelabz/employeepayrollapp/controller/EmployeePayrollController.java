package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {
	
	@RequestMapping(value= {"","/","get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Ranganath", 500000));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success",payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(2,new EmployeePayrollDTO("Harinath", 450000));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(3, employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(3, employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll Data for: ", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
		ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "empId "+empId);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
}














