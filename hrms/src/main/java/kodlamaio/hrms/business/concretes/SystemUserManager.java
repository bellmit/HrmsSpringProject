package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.SystemUserDao;
import kodlamaio.hrms.entities.concretes.Employer;
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
		if(!isExistSystemUserEmailOrName(systemUser)) {
		this.sytemUserDao.save(systemUser);
		return new SuccessResult("Sistem kullancısı eklendi");
		}
		return new ErrorResult(systemUser.getFirstName()+ "isimli sistem kullanıcısı ile aynı isimde başka bir kullanıcı olduğu için eklenemedi");
	}

	private boolean isExistSystemUserEmailOrName(SystemUser systemUser) {
		return this.sytemUserDao.findByEmailOrFirstName(systemUser.getEmail(),systemUser.getFirstName()) != null; 
	}


	@Override
	public Result delete(SystemUser systemUser) {
		Optional<SystemUser> systemuser = this.sytemUserDao.findById(systemUser.getId());
		if(systemuser.isPresent()) {
			this.sytemUserDao.deleteById(systemUser.getId());
			return new SuccessResult("Kullanıcı silindi");
		}
		return  new ErrorDataResult<List<Employer>>(systemUser.getId() + " id'li sistem kullanıcısı bulunamadı.");
	}

	@Override
	public SystemUser findByEmail(String email) {
		return this.sytemUserDao.findByEmail(email);
	}
	

	

}
