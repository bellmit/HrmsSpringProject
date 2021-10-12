package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Iş pozisyonları listelendi");
	}

	@Override
	public JobPosition getById(Integer id) {
		// TODO Auto-generated method stub
		Optional<JobPosition> jobPosition = this.jobPositionDao.findById(id);
		return jobPosition.isPresent() ? jobPosition.get() : null;
	}

	@Override
	public Result save(JobPosition jobPosition) {
		if (!existPositionByTitle(jobPosition)) {
			jobPositionDao.save(jobPosition);
			return new SuccessResult("Pozisyon kaydedildi");
		}
		return new ErrorDataResult<>(
				jobPosition.getTitle() + " isimli pozisyon sistemde kayıtlı olduğu için işlem başarısız oldu!");

	}

	private boolean existPositionByTitle(JobPosition jobPosition) {

		return jobPositionDao.findByTitle(jobPosition.getTitle()) != null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
