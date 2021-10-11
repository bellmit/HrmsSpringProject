package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{
	List<JobPosition> getByTitle(JobPosition jobPosition);
	
	JobPosition findByTitle(String title);
	
	JobPosition findById(JobPosition jobPosition);

	
}
