package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer>{
	
	List<ForeignLanguage> findByJobSeeker(JobSeeker jobSeeker);
	
	ForeignLanguage findByflanguageName(String flanguageName);
	
}
