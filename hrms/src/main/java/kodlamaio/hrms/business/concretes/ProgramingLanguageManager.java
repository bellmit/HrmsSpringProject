package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import kodlamaio.hrms.business.abstracts.ProgramingLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstarcts.ProgramingLanguageDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.ProgramingLanguage;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;
import kodlamaio.hrms.entities.dtos.ProgramingLanguageDto;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {
	private ProgramingLanguageDao programingLanguageDao;
	private JobSeekerDao jobSeekerDao;
	private final ModelMapper modelMapper;

	@Autowired
	public ProgramingLanguageManager(ProgramingLanguageDao programingLanguageDao, JobSeekerDao jobSeekerDao,
			ModelMapper modelMapper) {
		super();
		this.programingLanguageDao = programingLanguageDao;
		this.jobSeekerDao = jobSeekerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result save(ProgramingLanguageDto programingLanguageDto) {
		Optional<JobSeeker> jobSeeker = this.jobSeekerDao.findById(programingLanguageDto.getJobSeekerId());
		if (jobSeeker.isPresent()) {
			if (!existProgramingLanguage(programingLanguageDto)) {
				ProgramingLanguage programingLanguage = modelMapper.map(programingLanguageDto,
						ProgramingLanguage.class);
				ProgramingLanguage savedProgramingLanguage = this.programingLanguageDao.save(programingLanguage);
				return new SuccessDataResult(modelMapper.map(savedProgramingLanguage, ProgramingLanguageDto.class),
						"Başarılı şekilde kaydedildi");
			}
		}
		return new ErrorDataResult<>(programingLanguageDto.getPlanguageName() + " dili kayıtlı olduğu için yada "
				+ programingLanguageDto.getJobSeekerId()
				+ " id li iş arayan kişi sistemde kayıtlı olmadığı için işlem başarısız oldu!");
	}

	private boolean existProgramingLanguage(ProgramingLanguageDto programingLanguageDto) {

		return programingLanguageDao.findByplanguageName(programingLanguageDto.getPlanguageName()) != null;
	}

	@Override
	public DataResult<List<ProgramingLanguageDto>> getByJobSeekerId(int jobSeekerId) {
		Optional<JobSeeker> jobSeeker=jobSeekerDao.findById(jobSeekerId);
		if(jobSeeker.isPresent()) {
			List<ProgramingLanguage> programingLanguageList= programingLanguageDao.findByJobSeeker(jobSeeker.get());
			if(!CollectionUtils.isEmpty(programingLanguageList)) {
				List<ProgramingLanguageDto> dtoProgramingLanguageList=programingLanguageList.stream()
						.map(programingLanguage->modelMapper.map(programingLanguage,ProgramingLanguageDto.class))
						.collect(Collectors.toList());
				return new SuccessDataResult<List<ProgramingLanguageDto>>(dtoProgramingLanguageList,
						 "Başarılı şekilde listeniz geldi");
			}else {
				 return new ErrorDataResult<>(jobSeekerId + "ID'li jobseeker'a ait yabancı dil bulunmamaktadır.");
			 }
		}
		return new ErrorDataResult<>("aranan jobseeker olmadığı için veri getirilemiyor");
	}

}
