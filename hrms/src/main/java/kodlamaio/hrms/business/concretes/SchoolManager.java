package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstarcts.SchoolDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import kodlamaio.hrms.entities.dtos.SchoolDto;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	private JobSeekerDao jobSeekerDao;
	private final ModelMapper modelMapper;

	@Autowired
	public SchoolManager(SchoolDao schoolDao, JobSeekerDao jobSeekerDao, ModelMapper modelMapper) {
		super();
		this.schoolDao = schoolDao;
		this.jobSeekerDao = jobSeekerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<School>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result save(SchoolDto schoolDto) {
		Optional<JobSeeker> jobSeeker = jobSeekerDao.findById(schoolDto.getJobSeekerId());
		if (jobSeeker.isPresent()) {

			School school = modelMapper.map(schoolDto, School.class);

			if (!school.isGraduated()) {
				school.setGraduationYear(null);
			}

			School savedSchool = this.schoolDao.save(school);
			return new SuccessDataResult(modelMapper.map(savedSchool, SchoolDto.class));
		} else {
			return new ErrorDataResult<>("JobSeeker is not present");
		}
	}

	@Override
	public DataResult<List<SchoolDto>> getAll() {
		List<School> schools = this.schoolDao.findAll();
		List<SchoolDto> dtos = schools.stream().map(school -> modelMapper.map(school, SchoolDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<SchoolDto>>(dtos);

	}

	@Override
	public DataResult<List<SchoolDto>> getBySchoolNameStartsWith(String schoolName) {
		List<School> schoolList = schoolDao.getBySchoolNameStartsWith(schoolName);

		if (schoolList.isEmpty()) {
			return null;
		} else {
			List<SchoolDto> dtoSchoolList = schoolList.stream().map(school -> modelMapper.map(school, SchoolDto.class))
					.collect(Collectors.toList());
			return new SuccessDataResult<List<SchoolDto>>(dtoSchoolList);
		}

	}

}
