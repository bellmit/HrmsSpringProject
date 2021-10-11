package kodlamaio.hrms.business.abstracts;
import java.util.*;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService extends UserService{
	DataResult<List<JobPosition>> getAll(); //hangi türde veri döndüreceksem <> generik tipinde <> içerisine yazdım
	Result save(JobPosition jobPosition);
	JobPosition  getById(Integer id);
	
}
