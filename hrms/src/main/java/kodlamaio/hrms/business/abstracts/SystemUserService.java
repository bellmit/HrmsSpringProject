package kodlamaio.hrms.business.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;
import java.util.List;

public interface SystemUserService {
	DataResult<List<SystemUser>> getAll();
	Result add(SystemUser systemUser);
}
