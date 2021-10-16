package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;
import kodlamaio.hrms.entities.dtos.ProgramingLanguageDto;

public interface ProgramingLanguageService {
	
	Result save(ProgramingLanguageDto programingLanguageDto);

	DataResult<List<ProgramingLanguageDto>> getByJobSeekerId(int jobSeekerId);
}
