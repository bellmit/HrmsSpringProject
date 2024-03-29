package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CityDto;

public interface CityService {
	Result save(CityDto cityDto);
	
	DataResult<List<CityDto>> getAll();
}
