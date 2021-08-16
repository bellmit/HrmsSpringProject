package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstarcts.VerificationDao;
import kodlamaio.hrms.entities.concretes.Verification;
@Service
public class VerificationManager implements VerificationService {

	private VerificationDao verificationDao;
	
	public VerificationManager(VerificationDao verificationDao) {
		super();
		this.verificationDao=verificationDao;
	}
	@Override
	public DataResult<List<Verification>> getAll() {
		return new SuccessDataResult<List<Verification>>(this.verificationDao.findAll(), "Listelendi");
	}

	@Override
	public DataResult<Verification> getById(int id) {
		return new DataResult<Verification>((Verification) this.verificationDao.getById(id), true);	
				
	}
	@Override
	public Result add(Verification verification) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result update(Verification verification) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
