package kodlamaio.hrms.business.concretes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

//import org.graalvm.util.CollectionsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstarcts.VerificationDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationService verificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationService verificationService) {
		super();
		this.employerDao=employerDao;
		this.verificationService=verificationService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		List<Employer> employerList = this.employerDao.findAll();
		if(!CollectionUtils.isEmpty(employerList)) {
			return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
		}else{
			return new ErrorDataResult<List<Employer>>("Veri bulunamadı.");
		}
		
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Kaydedildi");
	}

}
