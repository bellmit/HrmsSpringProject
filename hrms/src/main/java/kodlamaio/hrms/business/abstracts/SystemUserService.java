package kodlamaio.hrms.business.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;
import java.util.List;

public interface SystemUserService extends UserService {
	DataResult<List<SystemUser>> getAll();

	Result add(SystemUser systemUser);

	Result delete(SystemUser systemUser);
}
