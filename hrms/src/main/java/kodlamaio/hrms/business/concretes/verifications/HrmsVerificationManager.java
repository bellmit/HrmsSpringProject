package kodlamaio.hrms.business.concretes.verifications;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.verifications.HrmsVerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class HrmsVerificationManager implements HrmsVerificationService{

	@Override
	public boolean verify(String data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Result add(int employerId, int personelId, boolean isVerify) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirm(User user) {
		// TODO Auto-generated method stub
		
	}

}
