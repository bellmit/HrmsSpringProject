package kodlamaio.hrms.business.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import java.util.List;


public interface JobSeekerService extends UserService{
	Result save(JobSeeker jobSeeker);
	Result delete(JobSeeker jobSeeker);
	//DataResult<List<JobSeeker>> getAll();
	DataResult<List<JobSeeker>> getAll();
	JobSeeker findByIdentityNumber(String identityNumber);
}
