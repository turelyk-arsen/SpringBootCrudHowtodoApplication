package howtodo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeeMvcController {

	@Autowired
	EmployeeService service;
	
	@RequestMapping
	public String getAllEmployees(Model model) {
		List<EmployeeEntity> list = service.getAllEmployees();
		
		model.addAttribute("employees", list);
		return "list-employees";
	}
	
	@RequestMapping(path= {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
	throws RecordNotFoundException {
		if (id.isPresent()) {
			EmployeeEntity entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new EmployeeEntity());
		}
		return "add-edit-employee";
	}
	
	@RequestMapping(path="/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
	throws RecordNotFoundException{
		service.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	@PostMapping(path="/createEmployee")
	public String createEmployee(EmployeeEntity employee) {
		service.createOrUpdateEmployee(employee);
		return "redirect:/";
	}
}
