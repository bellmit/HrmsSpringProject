package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hrms.business.abstracts.SytemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstarcts.SystemUserDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.SystemUser;
@Service
public class SystemUserManager implements SytemUserService {
	private SystemUserDao sytemUserDao;
	
	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao) {
		super();
		this.sytemUserDao=systemUserDao;
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(this.sytemUserDao.findAll(), "Hrms personeli listelendi");
	}

	@Override
	public Result add(SystemUser systemUser) {
		
		return null;
	}

}
