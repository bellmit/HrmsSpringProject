package kodlamaio.hrms.business.concretes.verifications;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.verifications.MernisVerificationService;
import kodlamaio.hrms.business.abstracts.verifications.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstarcts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class MernisVerificationManager implements MernisVerificationService {

	private UserDao userDao;
	private JobSeekerDao jobSeekerDao;
	private VerificationService verificationService;
	
	@Autowired
	public MernisVerificationManager(UserDao userDao,JobSeekerDao jobSeekerDao,VerificationService verificationService) {
		this.userDao=userDao;
		this.verificationService=verificationService;
		this.jobSeekerDao=jobSeekerDao;	
	}
	@Override
	public boolean verify(String data) {
		if(data != null && isValidIdentityNumber(data)) {
			return true;
		}
		return false;
	}

	private boolean isValidIdentityNumber(String data) {
		return data.length() == 11 || data.length()==10;
	}
	@Override
	public void confirm(JobSeeker JobSeeker) {
		 if(JobSeeker.isVerify()==true){
	            ((MernisVerificationService) jobSeekerDao).confirm(JobSeeker);
	            System.out.println(JobSeeker.getFirstName()+" "+JobSeeker.getLastName()+" e postanız doğrulanmıştır.");
	        }
	        else{
	            System.out.println(JobSeeker.getFirstName()+" "+ JobSeeker.getLastName()+ " e-postanız doğrulanmadı");
	        }
		
	}

	

}
