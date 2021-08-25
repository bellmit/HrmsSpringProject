package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.dataAccess.abstarcts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public User findByEmail(String email) {
		return this.userDao.findByEmail(email);
	}

}
