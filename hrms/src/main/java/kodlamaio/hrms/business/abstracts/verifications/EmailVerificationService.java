package kodlamaio.hrms.business.abstracts.verifications;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.verification.abstracts.VerificationAdapter;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;

public interface EmailVerificationService extends VerificationAdapter{
	public boolean confirm(String data);
	
}
