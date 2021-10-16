package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.mapping.ForeignKey;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.ForeignLanguageDao;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.ProgramingLanguage;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import kodlamaio.hrms.entities.dtos.ProgramingLanguageDto;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
	private JobSeekerDao jobSeekerDao;
	private ForeignLanguageDao foreignLanguageDao;
	private final ModelMapper modelMapper;

	public ForeignLanguageManager(JobSeekerDao jobSeekerDao, ForeignLanguageDao foreignLanguageDao,
			ModelMapper modelMapper) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.foreignLanguageDao = foreignLanguageDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result save(ForeignLanguageDto foreignLanguageDto) {
		Optional<JobSeeker> jobSeeker = jobSeekerDao.findById(foreignLanguageDto.getJobSeekerId());
		if (jobSeeker.isPresent()) {
			if (!existForeignLanguage(foreignLanguageDto)) {
				ForeignLanguage foreignLanguage = modelMapper.map(foreignLanguageDto, ForeignLanguage.class);
				ForeignLanguage savedForeignLanguage = this.foreignLanguageDao.save(foreignLanguage);
				return new SuccessDataResult(modelMapper.map(savedForeignLanguage, ForeignLanguageDto.class),
						"Başarılı şekilde kaydedildi");
			}
		}
		return new ErrorDataResult<>(foreignLanguageDto.getFlanguageName() + " dili kayıtlı olduğu için yada "
				+ foreignLanguageDto.getJobSeekerId()
				+ " id li iş arayan kişi sistemde kayıtlı olmadığı için işlem başarısız oldu!");
	}

	private boolean existForeignLanguage(ForeignLanguageDto foreignLanguageDto) {
		return foreignLanguageDao.findByflanguageName(foreignLanguageDto.getFlanguageName()) != null;

	}

	@Override
	public DataResult<List<ForeignLanguageDto>> getByJobSeekerId(int jobSeekerId) {
		Optional<JobSeeker> jobSeeker = jobSeekerDao.findById(jobSeekerId);
		if (jobSeeker.isPresent()) {
			List<ForeignLanguage> forignLanguageList = foreignLanguageDao.findByJobSeeker(jobSeeker.get());
			if (!CollectionUtils.isEmpty(forignLanguageList)) {
				List<ForeignLanguageDto> dtoForeignLanguageList = forignLanguageList.stream()
						.map(foreignLanguage -> modelMapper.map(foreignLanguage, ForeignLanguageDto.class))
						.collect(Collectors.toList());
				return new SuccessDataResult<List<ForeignLanguageDto>>(dtoForeignLanguageList,
						"Başarılı şekilde listeniz geldi");
			} else {
				return new ErrorDataResult<>(jobSeekerId + "ID'li jobseeker'a ait yabancı dil bulunmamaktadır.");
			}
		}
		return new ErrorDataResult<>("aranan jobseeker olmadığı için veri getirilemiyor");
	}

}
