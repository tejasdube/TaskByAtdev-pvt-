package ATdev.Crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ATdev.Crud.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	

}
