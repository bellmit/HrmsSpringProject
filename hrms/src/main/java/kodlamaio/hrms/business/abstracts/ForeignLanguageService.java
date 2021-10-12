package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;

public interface ForeignLanguageService {
	Result save(ForeignLanguageDto foreignLanguageDto);

	DataResult<List<ForeignLanguageDto>> getByJobSeekerId(int jobSeekerId);
}
