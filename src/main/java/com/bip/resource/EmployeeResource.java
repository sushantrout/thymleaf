package com.bip.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bip.entity.Employee;
import com.bip.service.EmployeeService;

@Controller
@RequestMapping(value="/emp")
public class EmployeeResource {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping(value="")
	public String getEmployeeForm(Employee employee) {
		return "employee/add-employee";
	}
	@PostMapping(value="/addemployee")
	public String createEmployee(@Valid Employee employee){
		employeeService.createEmployee(employee);
		return "redirect:list";
	}
	@GetMapping(value="/list")
	public String getEmployees(ModelMap model){
		model.addAttribute("emplist", employeeService.findAll());
		return "employee/employee-list";
	}
	@GetMapping(value="update/{id}")
	public String updateEmployee(@PathVariable("id") Long id,Model model, Employee employee) {
		employee = employeeService.findOne(id);
		model.addAttribute("employee", employee);
		return "employee/add-employee";
	}
	@GetMapping(value="countries")
	public String getCountryList(Model model) {
		List<String> countries = new ArrayList<>();
		countries.add("INDIA");
		countries.add("PAK");
		countries.add("SRILANKA");
		model.addAttribute("countries", countries);
		return "countries/countries-list";
	}
}
