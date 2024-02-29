package ATdev.Crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ATdev.Crud.entity.Student;
import ATdev.Crud.repo.StudentRepo;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;

	// get all students

	@GetMapping
	public List<Student> getAllStudent() {
		return studentRepo.findAll();

	}

	// get by id
	@GetMapping("/{id}")
	public Student getByid(@PathVariable int id) {

		return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found by these id " + id));

	}

	// post the student
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepo.save(student);

	}

	// update the student
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {

		Student exiStudent = studentRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("student not found by these id " + id));

		exiStudent.setName(updatedStudent.getName());
		exiStudent.setEmail(updatedStudent.getEmail());
		exiStudent.setDept(updatedStudent.getDept());
		return studentRepo.save(exiStudent);
	}

	//
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		studentRepo.deleteById(id);
	}
}
