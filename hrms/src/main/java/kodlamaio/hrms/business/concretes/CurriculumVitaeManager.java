package kodlamaio.hrms.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private static final int Optional = 0;
	private CurriculumVitaeDao curriculumVitaeDao;
	private CurriculumVitae curriculumVitae;
	private JobSeekerDao jobSeekerDao;

	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, JobSeekerDao jobSeekerDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "Datas are listed");

	}

	@Override
	public DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId) {
		this.curriculumVitae = curriculumVitaeDao.getByJobSeekerId(jobSeekerId);
		return new SuccessDataResult<>(curriculumVitaeDao.getByJobSeekerId(jobSeekerId), "cv başarıyla getirildi");
	}

	@Override
	public DataResult<List<kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto>> JobSeekerWithCvDto(Integer id) {
		this.curriculumVitaeDao.jobSeekerWithCvDto(id);
		return new SuccessDataResult<>("Başarı ile cv geldi");

	}

	@Override
	public DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithGraduationYear(String ascOrDesc) {
		if (ascOrDesc.equalsIgnoreCase("Desc")) {
			this.curriculumVitae.getSchools().sort(Comparator.comparing(School::getGraduationYear).reversed());
		} else {
			this.curriculumVitae.getSchools().sort(Comparator.comparing(School::getGraduationYear));
		}
		return new SuccessDataResult<>(this.curriculumVitae, "Okullar mezuniyet tarihine göre sıralanmıştır");
	}

	@Override
	public DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithEndedDate(String ascOrDesc) {
		if (ascOrDesc.equalsIgnoreCase("Desc")) {
			this.curriculumVitae.getJobExperiences().sort(Comparator.comparing(JobExperience::getEndedDate).reversed());
		} else {
			this.curriculumVitae.getJobExperiences().sort(Comparator.comparing(JobExperience::getEndedDate));
		}
		return new SuccessDataResult<>(this.curriculumVitae, "Deneyimler işten ayrılma tarihine göre sıralandı");
	}

}
