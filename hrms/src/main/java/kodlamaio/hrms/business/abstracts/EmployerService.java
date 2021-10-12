package kodlamaio.hrms.business.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface EmployerService extends UserService {
	DataResult<List<Employer>> getAll();

	Result save(Employer employer);
}
