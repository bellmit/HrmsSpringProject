package kodlamaio.hrms.business.abstracts;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;
public interface VerificationService {
	DataResult<List<Verification>> getAll(); 
	
	DataResult<Verification> getById(int id);
	Result add(Verification verification);
	Result update(Verification verification);
	Result delete(int id);
}
