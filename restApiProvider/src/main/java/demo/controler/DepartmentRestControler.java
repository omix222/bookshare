package demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Department;
import demo.service.DepartmentService;
@RestController
@CrossOrigin
@RequestMapping("api/departments")
public class DepartmentRestControler {
	@Autowired
	DepartmentService departmentService;
	
	public DepartmentRestControler() {
		super();
	}

	@GetMapping
	List<Department> getDepartments() {
		return departmentService.getDepartments();
	}

	@GetMapping(path = "{id}")
	Department getDepartment(@PathVariable String id) {
		return departmentService.getDepartment(id);
	}
	
	@PostMapping
	Department postDepartment(@RequestBody Department newDepartment) {
		return departmentService.addDepartment(newDepartment);
	}
	
	@DeleteMapping
	public void deleteDepartment(@PathVariable String id) {
		departmentService.deleteDepartment(id);
	}
}
