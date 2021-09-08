package kodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	 Result save(JobAdvertisement jobAdvertisement);
	
	 Result update(JobAdvertisement jobAdvertisement);
	
	 Result delete(JobAdvertisement jobAdvertisement);
	 
	 DataResult<List<JobAdvertisement>> getByActiveJobAdvertisements();
	
	 DataResult<List<JobAdvertisement>> getByReleaseDateDesc();
	
	 DataResult<List<JobAdvertisement>> getAllApplicationDeadlineDesc();
	
	 DataResult<List<JobAdvertisement>> getByIsActiveJobAdvertisementAndEmployer_CompanyName(boolean isActive, String companyName);
	
	 //public Result closeJobPosting(int id);

	 //public Result openJobPosting(int id);
	
}
