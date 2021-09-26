package kodlamaio.hrms.business.concretes;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{


private CurriculumVitaeDao curriculumVitaeDao;
private  CurriculumVitae  curriculumVitae;

	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao)	{
	super();
	this.curriculumVitaeDao = curriculumVitaeDao;
	}


  @Override
  public Result save(CurriculumVitae curriculumVitae) {  
	  //Eğer mezun değilse mezuniyet tarihini girmesin boş bıraksın.
 	  List<School> schools=curriculumVitae.getSchools();
	  for(School school:schools) {
		  if(!school.isGraduated()) {
			  school.setGraduationYear(null);
		  }
	  }
	  //Eğer işte hala çalışıyorsa işten ayrılma yılı boş geçilebilmelidir.
	  List<JobExperience> experiences=curriculumVitae.getJobExperiences();
	  for(JobExperience jobExperience:experiences) {
		  if(!jobExperience.isStillWork()) {
			  jobExperience.setEndedDate(null);
		  }
	  }
	  curriculumVitaeDao.save(curriculumVitae); 
	  return new SuccessResult("Başarılı şekilde cv kaydedildi"); 
	  }
 

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new DataResult<List<CurriculumVitae>>
		(this.curriculumVitaeDao.findAll(), false, "Datalar listelendi" );
		
	}
	@Override
	public DataResult<CurriculumVitae> getAllByJobSeekerId(int jobSeekerId) {
		this.curriculumVitae=curriculumVitaeDao.getAllByJobSeekerId(jobSeekerId);
		return new SuccessDataResult<>(curriculumVitaeDao.getAllByJobSeekerId(jobSeekerId),"cv başarıyla getirildi");
	}
	
	@Override
	public DataResult<List<kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto>> JobSeekerWithCvDto(Integer id) {
		this.curriculumVitaeDao.jobSeekerWithCvDto(id);
		return new SuccessDataResult<>("Başarı ile cv geldi");
		
	}


	@Override
	public DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithGraduationYear(String ascOrDesc) {
		if(ascOrDesc.equalsIgnoreCase("Desc")) {
			this.curriculumVitae.getSchools().sort(Comparator.comparing(School::getGraduationYear).reversed());
		}else {
			this.curriculumVitae.getSchools().sort(Comparator.comparing(School::getGraduationYear));
		}
		return new SuccessDataResult<>(this.curriculumVitae,"Okullar mezuniyet tarihine göre sıralanmıştır");
	}


	@Override
	public DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithEndedDate(String ascOrDesc) {
		if(ascOrDesc.equalsIgnoreCase("Desc")) {
			this.curriculumVitae.getJobExperiences().sort(Comparator.comparing(JobExperience::getEndedDate).reversed());
		}
		else {
			this.curriculumVitae.getJobExperiences().sort(Comparator.comparing(JobExperience::getEndedDate));
		}
		return new SuccessDataResult<>(this.curriculumVitae,"Deneyimler işten ayrılma tarihine göre sıralandı");
	}
	


}
