package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.SchoolDto;

@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.jobSeekerDao=jobSeekerDao;
		this.curriculumVitaeDao=curriculumVitaeDao;
	}
	@Override
	public Result save(JobSeeker jobSeeker) {
		if(!isExistJobSeekerWithIdentityNumberOrEmail(jobSeeker)) {
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Aday eklendi");
		}
		return new ErrorResult("Kaydedilemedi, sistemde aynı kimlik numarası veya email ile kayıtlı bir kullanıcı mevcuttur.");
	}

	private boolean isExistJobSeekerWithIdentityNumberOrEmail(JobSeeker jobSeeker) {
		
		return this.jobSeekerDao.findByIdentityNumberOrEmail(jobSeeker.getIdentityNumber(), jobSeeker.getEmail()) != null;
	}
	
	private boolean isExistJobSeekerWithEmail(JobSeeker jobSeeker) {
		
		return findByEmail(jobSeeker.getEmail()) != null;
	}

	private boolean isExistJobSeekerWithIdentityNumber(JobSeeker jobSeeker) {
		
		return findByIdentityNumber(jobSeeker.getIdentityNumber())!=null;
	}
	
	@Override
	public Result delete(String jobSeekerId) {
		Optional<JobSeeker> jobSeeker = jobSeekerDao.findById(Integer.valueOf(jobSeekerId));
		if (jobSeeker.isPresent()) {
			this.jobSeekerDao.delete(jobSeeker.get());
			return new SuccessResult("Aday silindi");
		}
		return new ErrorResult(
				"Silinemedi, sistemde " + jobSeekerId + " ID'li  bir kullanıcı mevcut değildir.");
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

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Updated datas");
	}
	
	


}
