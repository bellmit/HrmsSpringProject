package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao=jobSeekerDao;
	}
	
	@Override
	public Result save(JobSeeker jobSeeker) {
		if(!isExistJobSeekerWithIdentityNumber(jobSeeker) && !isExistJobSeekerWithEmail(jobSeeker)) {
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Aday eklendi");
		}
		return new ErrorResult("Kaydedilemedi, sistemde aynı kimlik numarası veya email ile kayıtlı bir kullanıcı mevcuttur.");
	}

	private boolean isExistJobSeekerWithEmail(JobSeeker jobSeeker) {
		
		return findByEmail(jobSeeker.getEmail()) != null;
	}

	private boolean isExistJobSeekerWithIdentityNumber(JobSeeker jobSeeker) {
		
		return findByIdentityNumber(jobSeeker.getIdentityNumber())!=null;
	}
	
	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
		return new SuccessResult("Aday silindi");
	}

	@Override
	public User findByEmail(String email) {
		return this.jobSeekerDao.findByEmail(email);
	}

	@Override
	public JobSeeker findByIdentityNumber(String identityNumber) {
		return this.jobSeekerDao.findByIdentityNumber(identityNumber);
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new DataResult<List<JobSeeker>>(jobSeekerDao.findAll(),true,"Adaylar listelendi");
	}
	/*@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.getAll(), "İş arayanlar listelendi");
		
	}*/
	


}
