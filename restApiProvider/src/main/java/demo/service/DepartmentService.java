package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Department;
import demo.repository.DepartmentRepository;
@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository repository;
	
	public Department getDepartment(String id) {
		return repository.getOne(id);
	}
	
	public List<Department> getDepartments(){
		return repository.findAll();
	}
	
	public Department addDepartment(Department department) {
		repository.save(department);
		return repository.getOne(department.getId());
	}
	
	public Department updateDepartment(Department department) {
		repository.save(department);
		return repository.getOne(department.getId());
	}
	public void deleteDepartment(String id) {
		repository.deleteById(id);
	}
}
