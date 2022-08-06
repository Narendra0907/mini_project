package com.nt.service;

import java.util.List;

import com.nt.modal.Employee;

public interface IEmployeeServiceMgnt {

	public List<Employee> fetchAllEmps();
    public String registerEmployee(Employee emp);
    public String deleteEmployee(int eno);
    public Employee fetchEmployeeByNo(int no);
    public String modifyEmployee(Employee emp); 
}
