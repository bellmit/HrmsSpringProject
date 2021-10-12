package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstarcts.JobExperienceDao;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	private JobSeekerDao jobSeekerDao;
	private final ModelMapper modelMapper;

	public JobExperienceManager(JobExperienceDao jobExperienceDao, JobSeekerDao jobSeekerDao) {
		super();
		this.modelMapper = new ModelMapper();
		this.jobExperienceDao = jobExperienceDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result save(JobExperienceDto jobExperienceDto) {
		Optional<JobSeeker> jobSeeker = jobSeekerDao.findById(jobExperienceDto.getJobSeekerId());
		JobExperience jobExperience = modelMapper.map(jobExperienceDto, JobExperience.class);
		if (jobExperience.isStillWork() != false) {
			jobExperienceDto.setEndedDate(null);
		}
		JobExperience savedJobExperience = this.jobExperienceDao.save(jobExperience);
		return new SuccessDataResult(modelMapper.map(savedJobExperience, JobExperienceDto.class));
	}

	@Override
	public DataResult<List<JobExperienceDto>> getAll() {
		List<JobExperience> jobExperiences = this.jobExperienceDao.findAll();
		List<JobExperienceDto> dtos = jobExperiences.stream()
				.map(jobExperience -> modelMapper.map(jobExperience, JobExperienceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<JobExperienceDto>>(dtos);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
