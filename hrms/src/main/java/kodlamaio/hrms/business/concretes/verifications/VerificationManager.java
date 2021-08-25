package kodlamaio.hrms.business.concretes.verifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.verifications.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.verifications.EmailVerificationService;
import kodlamaio.hrms.dataAccess.abstarcts.VerificationDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService{
	private VerificationDao verificationDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;
	
	@Autowired
	public VerificationManager(VerificationDao verificationDao, EmailVerificationService emailVerificationService) {
		this.verificationDao=verificationDao;
		this.emailVerificationService=emailVerificationService;
	}

	@Override
	public Result confirm(User user) {
		return null;
		
	}

	@Override
	public Result verify(Verification verification) {
		return null;
	}

	@Override
	public boolean verify(String data) {
		return false;
	}
}
