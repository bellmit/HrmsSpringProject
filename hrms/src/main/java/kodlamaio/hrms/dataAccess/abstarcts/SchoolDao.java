package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.School;
//import kodlamaio.hrms.entities.dtos.SchoolDto;

public interface SchoolDao extends JpaRepository<School, Integer> {
	List<School> getBySchoolName(String schoolName);
	
	List<School> getByJobSeekerId(int jobSeekerId);
	
}
