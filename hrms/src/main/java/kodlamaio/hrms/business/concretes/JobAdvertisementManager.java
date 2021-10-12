package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result save(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanınız başarılı şekilde kaydedildi");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanınız güncellendi");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İş ilanınız başarıyla silindi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveJobAdvertisements() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveJobAdvertisements(),
				"Aktif iş ilanları getirildi");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getByReleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByReleaseDateDesc(),
				"İş ilanları yayın tarihine göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllApplicationDeadlineDesc(),
				"İş ilanları son geçerlilik tarihine göre listelendi");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveJobAdvertisementAndEmployer_CompanyName(boolean isActive,
			String companyName) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName), companyName);
	}

	@Override
	public Result setJobAdvertisementStatus(int id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı sonlandırıldı");
	}

}
