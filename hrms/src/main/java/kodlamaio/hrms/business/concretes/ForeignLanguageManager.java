package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.ForeignKey;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.ForeignLanguageDao;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;
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
		if (!existForeignLanguage(foreignLanguageDto)) {
			ForeignLanguage foreignLanguage = modelMapper.map(foreignLanguageDto, ForeignLanguage.class);
			ForeignLanguage savedForeignLanguage = this.foreignLanguageDao.save(foreignLanguage);
			return new SuccessDataResult(modelMapper.map(savedForeignLanguage, ForeignLanguageDto.class));
		}
		return new ErrorDataResult<>(foreignLanguageDto.getFlanguageName()
				+ " isimli pozisyon sistemde kayıtlı olduğu için işlem başarısız oldu!");
	}

	private boolean existForeignLanguage(ForeignLanguageDto foreignLanguageDto) {
		return foreignLanguageDao.findByflanguageName(foreignLanguageDto.getFlanguageName()) != null;

	}

	@Override
	public DataResult<List<ForeignLanguageDto>> getByJobSeekerId(int jobSeekerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
