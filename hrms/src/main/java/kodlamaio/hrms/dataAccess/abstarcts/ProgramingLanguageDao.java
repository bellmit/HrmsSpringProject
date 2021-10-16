package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.ProgramingLanguage;
import kodlamaio.hrms.entities.dtos.ProgramingLanguageDto;

public interface ProgramingLanguageDao extends JpaRepository<ProgramingLanguage,Integer>{
	
	List<ProgramingLanguage> findByJobSeeker(JobSeeker jobSeeker);
	
	ProgramingLanguage findByplanguageName(String planguageName);
	
}
