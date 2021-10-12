package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;

public interface SchoolService {

	Result save(SchoolDto school);

	// DataResult <List<School>> getBySchoolName(String schoolName);

	DataResult<List<SchoolDto>> getBySchoolNameStartsWith(String schoolName);

	DataResult<List<School>> getByJobSeekerId(int jobSeekerId);

	DataResult<List<SchoolDto>> getAll();

}
