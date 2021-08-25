package kodlamaio.hrms.business.concretes.verifications;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.verifications.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;

@Service
public class EmailVerificationManager implements EmailVerificationService {
	



	@Override
	public boolean verify(String data) {
		if(data!=null && isValidIdentityNumber(data)) {
			return true;
		}
		return false;
	}
	private boolean isValidIdentityNumber(String data) {
		return data.length()==11 || data.length()==10;
	}
	
	@Override
	public boolean confirm(String data) {
		return true;
	}
}
