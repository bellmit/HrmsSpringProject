package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{
private CurriculumVitaeDao curriculumVitaeDao;

	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao)	{
	super();
	this.curriculumVitaeDao = curriculumVitaeDao;
	}


  @Override
  public Result save(CurriculumVitae curriculumVitae) {
	  curriculumVitaeDao.save(curriculumVitae); 
	  return new SuccessResult("Başarılı şekilde cv kaydedildi"); 
	  }
 

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new DataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), false, "Datalar listelendi" );
		
	}

	@Override
	public DataResult<List<kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto>> JobSeekerWithCvDto(Integer id) {
		this.curriculumVitaeDao.jobSeekerWithCvDto(id);
		return new SuccessDataResult<>("Başarı ile cv geldi");
		
	}


}
