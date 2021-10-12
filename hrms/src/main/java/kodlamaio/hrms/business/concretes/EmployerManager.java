package kodlamaio.hrms.business.concretes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		List<Employer> employerList = this.employerDao.findAll();
		if (!CollectionUtils.isEmpty(employerList)) {
			return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
		} else {
			return new ErrorDataResult<List<Employer>>("Veri bulunamadı.");
		}
	}

	@Override
	public Result save(Employer employer) {

		if (!existEmployerByCompanyName(employer)) {
			employerDao.save(employer);
			return new SuccessResult("İş veren kaydedildi");
		}
		return new ErrorDataResult<>(
				employer.getCompanyName() + " isimli İş veren sistemde kayıtlı olduğundan işlem başarısız oldu!");

	}

	private boolean existEmployerByCompanyName(Employer employer) {
		return employerDao.findByCompanyName(employer.getCompanyName()) != null;

	}

	@Override
	public Employer findByEmail(String email) {
		return this.employerDao.findByEmail(email);
	}

}
