package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.modal.Employee;
import com.nt.service.IEmployeeServiceMgnt;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeServiceMgnt service;
	
	@GetMapping("/")
	public String showHomePage()
	{
		// return LVN
		return "home";
	}
	@GetMapping("/employee_report")
	public String showEmployeeReport(Map<String,Object> map)
	{
		List<Employee> list=service.fetchAllEmps();
		map.put("empsData",list);
		return "show_emp_report";
		
		}
	@GetMapping("/employee_add")
	public String showAddEmployeeFormPage(@ModelAttribute("emp")Employee emp){
		return "employee_register";
	}
	@PostMapping("/employee_add")
	public String processAddEmployeeFrom(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs) {
		String msg=service.registerEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:employee_report";
	}
	
	@GetMapping("/employee_delete")
	public String processdeleteEmployee(@RequestParam("no") int no,RedirectAttributes attrs) {
		String msg=service.deleteEmployee(no);
		attrs.addAttribute("resultMsg",msg);
		return "redirect:employee_report";
	}
	@GetMapping("/employee_edit")
	public String showUpdateEmployeeFormPage(@ModelAttribute("emp")Employee emp,@RequestParam("no") int no) {
		Employee emp1=service.fetchEmployeeByNo(no);
		BeanUtils.copyProperties(emp1, emp);
		return "employee_modify";
	
}
	@PostMapping("/employee_modify")
	public String processUpdateEmployeeFormPage(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs) {
		String msg=service.modifyEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:employee_report";
	}
}
