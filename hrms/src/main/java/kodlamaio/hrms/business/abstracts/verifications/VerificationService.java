package kodlamaio.hrms.business.abstracts.verifications;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.verification.abstracts.VerificationAdapter;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;

public interface VerificationService extends VerificationAdapter{
	public Result confirm(User user);
	public Result verify(Verification verification);
}
