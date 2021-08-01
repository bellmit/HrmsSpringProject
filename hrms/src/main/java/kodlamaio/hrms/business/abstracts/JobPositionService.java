package kodlamaio.hrms.business.abstracts;
import java.util.*;

import kodlamaio.hrms.entities.concretes.JobPosition;
public interface JobPositionService {
	List<JobPosition> getAll();
	JobPosition  getById(Integer id);
}
