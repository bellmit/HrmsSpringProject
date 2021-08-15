package kodlamaio.hrms.business.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SystemUser;
import java.util.List;
public interface SytemUserService {
	DataResult<List<SystemUser>> getAll();
	Result add(SystemUser systemUser);
}
