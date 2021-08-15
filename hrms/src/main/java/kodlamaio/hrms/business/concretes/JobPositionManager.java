package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		// Datası this.jobPositionDao.findAll dur ve message ise "data listelendi" dir.
		//SuccessDataResult ı new leyebiliyoruz çünkü atası DataResulttır.
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Iş pozisyonları listelendi");
		
		
		}

	@Override
	public JobPosition getById(Integer id) {
		// TODO Auto-generated method stub
		Optional<JobPosition> jobPosition = this.jobPositionDao.findById(id);
		return jobPosition.isPresent() ? jobPosition.get() : null ;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("kaydedildi");
	}

}
