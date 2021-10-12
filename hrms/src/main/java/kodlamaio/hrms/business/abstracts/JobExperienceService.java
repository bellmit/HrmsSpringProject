package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

public interface JobExperienceService extends UserService {
	Result save(JobExperienceDto jobExperienceDto);

	DataResult<List<JobExperienceDto>> getAll();

}
