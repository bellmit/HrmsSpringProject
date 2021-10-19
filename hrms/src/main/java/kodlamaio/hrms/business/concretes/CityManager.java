package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.CityDao;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.CityDto;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import lombok.Data;
import net.bytebuddy.asm.Advice.This;

@Service
@Data
public class CityManager implements CityService {
	private CityDao cityDao;
	private final ModelMapper modelMapper;
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public CityManager(CityDao cityDao, ModelMapper modelMapper,JobSeekerDao jobSeekerDao) {
		this.cityDao = cityDao;
		this.modelMapper = modelMapper;
		this.jobSeekerDao=jobSeekerDao;
		
	}
	/*@Override
	public Result save(CityDto cityDto) {
		City city = modelMapper.map(cityDto, City.class);
		if (!existCity(cityDto.getCityName())) {
			City savedCity = this.cityDao.save(city);
			return new SuccessDataResult(modelMapper.map(savedCity, CityDto.class), "Başarılı şekilde kaydedildi");
		} else {
			return new ErrorDataResult(cityDto.getCityName(), "kayıtlı olduğu için kaydedilemedi");
		}
	}*/
	/*private boolean existCity(String city) {
	return cityDao.findByCityName(city) != null;
	}*/
	
	@Override
	public Result save(CityDto cityDto) {
		Optional<JobSeeker> jobSeeker=jobSeekerDao.findById(cityDto.getJobSeekerId());
		if(jobSeeker.isPresent()) {
			City city=modelMapper.map(cityDto, City.class);
			City savedCity=this.cityDao.save(city);
			return new SuccessDataResult(modelMapper.map(savedCity, City.class));
		}else  {
			return new ErrorDataResult<>("JobSeeker is not present");
		}
	}
	/*@Override
	public Result save(CoverLetterDto coverLetterDto) {
		Optional<JobSeeker> jobSeeker=jobSeekerDao.findById(coverLetterDto.getJobSeekerId());
		if(jobSeeker.isPresent()) {
			CoverLetter coverLetter=modelMapper.map(coverLetterDto, CoverLetter.class);
			CoverLetter savedCoverLetter=this.coverLetterDao.save(coverLetter);
			return new SuccessDataResult(modelMapper.map(savedCoverLetter, CoverLetter.class));
		}else  {
			return new ErrorDataResult<>("JobSeeker is not present");
		}
	}*/
	@Override
	public DataResult<List<CityDto>> getAll() {
		List<City> cities = this.cityDao.findAll();
		List<CityDto> dtos = cities.stream().map(city -> modelMapper.map(city, CityDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CityDto>>(dtos);
	}

}
