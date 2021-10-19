package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;

public interface CoverLetterService {
	Result save(CoverLetterDto coverLetterDto);
	
	Result deleteById(int id);
	
	Result update(int jobSeekerId,String text);
}
