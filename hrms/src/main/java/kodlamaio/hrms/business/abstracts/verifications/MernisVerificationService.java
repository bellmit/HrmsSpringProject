package kodlamaio.hrms.business.abstracts.verifications;

import kodlamaio.hrms.core.utilities.verification.abstracts.VerificationAdapter;
import kodlamaio.hrms.entities.concretes.JobSeeker;


public interface MernisVerificationService extends VerificationAdapter{
	public boolean verify(String data);
	public void confirm(JobSeeker JobSeeker);
}
