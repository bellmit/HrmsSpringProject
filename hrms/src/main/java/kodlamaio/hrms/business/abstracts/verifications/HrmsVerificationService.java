package kodlamaio.hrms.business.abstracts.verifications;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.verification.abstracts.VerificationAdapter;
import kodlamaio.hrms.entities.concretes.User;

public interface HrmsVerificationService extends VerificationAdapter{
	public Result add(int employerId,int personelId, boolean isVerify);
	public void confirm(User user);
}
