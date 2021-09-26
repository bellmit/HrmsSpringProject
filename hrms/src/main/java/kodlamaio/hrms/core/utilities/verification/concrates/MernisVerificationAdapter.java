package kodlamaio.hrms.core.utilities.verification.concrates;

import kodlamaio.hrms.core.utilities.verification.abstracts.VerificationAdapter;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstarcts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;

public class MernisVerificationAdapter implements VerificationAdapter {
	private JobSeeker jobSeeker;
	

	public MernisVerificationAdapter(JobSeeker jobSeeker) {
		super();
		this.jobSeeker = jobSeeker;
	}


	@Override
	public boolean verify(String identityNumber ) {
		return true;
	}

}
