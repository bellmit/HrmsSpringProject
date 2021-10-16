package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{

	JobSeeker findByIdentityNumber(String identityNumber);
	
	JobSeeker findByEmail(String email);
	
	JobSeeker findByIdentityNumberOrEmail(String identityNumber,String email);
	
	JobSeeker getById(int id);
	
	


}
