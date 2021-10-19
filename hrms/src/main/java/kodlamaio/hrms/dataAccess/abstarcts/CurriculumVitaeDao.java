package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto;
public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto(cv.cvId,js.identityNumber,js.firstName,js.lastName,i.imageUrl,"
			+ "s.schoolName,s.departmant,s.startDate,s.graduationYear,"
			+"p.planguageName,p.plevel,f.flanguageName,f.level,cl.text,sl.socialUrl,"
			+"je.isStillWork,je.startedDate,je.endedDate,je.companyName,c.cityName) "
					+"From CurriculumVitae cv"
					+" Inner Join cv.jobSeeker js Inner Join cv.images i Inner Join cv.schools s Inner Join cv.programingLanguages p Inner Join cv.foreignLanguages f "
					+" Inner Join cv.coverLetters cl Inner Join cv.socialLinks sl Inner Join cv.jobExperiences je Inner Join cv.city c"
					+" where cv.cvId=:id")
	
	List<JobSeekerWithCvDto> jobSeekerWithCvDto(Integer id);
	
	CurriculumVitae getByJobSeekerId(int jobSeekerId);
	
	CurriculumVitae findByJobSeekerId(JobSeeker jobSeeker);
	
	
	
}