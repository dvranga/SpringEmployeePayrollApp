package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name Invalid")
	@NotEmpty(message="Employee name cannot be null ")
	public String name;
	
	@Min(value = 500, message="Min wage should be more than 500 ")
	public long salary;
	
	public String gender;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	public LocalDate startDate;
	
	public String note;
	
	public String profilePic;
	
	public List<String> departments;
	
}
