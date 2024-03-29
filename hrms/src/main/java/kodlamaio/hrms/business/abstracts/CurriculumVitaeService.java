package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto;

public interface CurriculumVitaeService {
	
	DataResult<List<CurriculumVitae>> getAll();

	DataResult<List<JobSeekerWithCvDto>> JobSeekerWithCvDto(Integer id);

	DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId);

	DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithGraduationYear(String ascOrDesc);

	DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithEndedDate(String ascOrDesc);

}
