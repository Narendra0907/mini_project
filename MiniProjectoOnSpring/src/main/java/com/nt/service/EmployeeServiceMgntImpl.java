package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.modal.Employee;

@Service("empService")
public class EmployeeServiceMgntImpl implements IEmployeeServiceMgnt {

	@Autowired
	private IEmployeeDAO empDAO;
	
	@Override
	public List<Employee> fetchAllEmps() {
		
		List<Employee> list=empDAO.getAllEmployees();
		return list;
	}
     @Override
    public String registerEmployee(Employee emp) {

    	 int count=empDAO.insert(emp);
    	 return count==0?"Employee not registered":"Employee registerd";
}
	@Override
	public String deleteEmployee(int eno) {
		int count=empDAO.remove(eno);
		
		return count==0?"employee not removed":"employee removed";
	}
	@Override
	public Employee fetchEmployeeByNo(int no) {
		Employee emp=empDAO.getEmployeeByNo(no);
		return emp;
	}
	@Override
	public String modifyEmployee(Employee emp) {
	int  count =empDAO.update(emp);
	return count==0?"Employee not update":"Employee update";
	}
}