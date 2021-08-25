package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.SystemUserDao;
import kodlamaio.hrms.entities.concretes.SystemUser;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class SystemUserManager implements SystemUserService {
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
		this.sytemUserDao.save(systemUser);
		return new SuccessResult("Sistem kullancısı eklendi");
	}

	@Override
	public Result delete(SystemUser systemUser) {
		this.sytemUserDao.deleteById(systemUser.getId());
		return new SuccessResult("Kullanıcı silindi");
	}

	@Override
	public SystemUser findByEmail(String email) {
		return this.sytemUserDao.findByEmail(email);
	}
	

	

}
