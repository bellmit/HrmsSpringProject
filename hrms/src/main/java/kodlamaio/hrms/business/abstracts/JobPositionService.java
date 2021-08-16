package kodlamaio.hrms.business.abstracts;
import java.util.*;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll(); //hangi türde veri döndüreceksem <> generik içerisine yazdım
	Result add(JobPosition jobPosition);
	JobPosition  getById(Integer id);
}
