package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
	
	List<School> getBySchoolNameStartsWith(String schoolName);
	
	List<School> getByJobSeekerId(int jobSeekerId);
	
	
}
