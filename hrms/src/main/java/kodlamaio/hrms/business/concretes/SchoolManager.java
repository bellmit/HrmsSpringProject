package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;
//import kodlamaio.hrms.entities.dtos.SchoolDto;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getBySchoolName(String schoolName) {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), "schoolName");
	}

	@Override
	public DataResult<List<School>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result save(School school) {
		this.schoolDao.save(school);
		return new SuccessDataResult("Okul kaydedildi");
		
	}

	/*@Override
	public DataResult<List<SchoolDto>> getJobSeekerWithSchoolDetails() {
		return new SuccessDataResult<List<SchoolDto>>(this.schoolDao.getJobSeekerWithSchoolDetails(), "öğrencinin adı,soyadı,okuduğu okullar ve bölümleri başarıyla getirildi.");
	}*/

}
