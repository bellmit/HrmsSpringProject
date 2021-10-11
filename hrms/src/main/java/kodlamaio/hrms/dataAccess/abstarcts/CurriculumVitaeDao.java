package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto(cv.cvId,js.identityNumber,js.firstName,js.lastName,i.imageUrl,s.schoolName,s.departmant,s.startDate,"
			+ "s.graduationYear,p.planguageName,p.plevel,f.flanguageName,f.level,cv.coverLetter,cv.githupLink,cv.linkedlnLink,je.isStillWork,"
			+ "je.startedDate,je.endedDate,je.companyName) "
			+"From CurriculumVitae cv Inner Join cv.jobSeeker js Inner Join cv.schools s Inner Join cv.foreignLanguages f " 
			+"Inner Join cv.programingLanguages p "
			+"Inner Join cv.jobExperiences je Inner Join cv.images i  where cv.cvId=:id")
	List<JobSeekerWithCvDto> jobSeekerWithCvDto(Integer id);
	
	CurriculumVitae getAllByJobSeekerId(int jobSeekerId);
	
	CurriculumVitae findByJobSeekerId(JobSeeker jobSeeker);
	
	
	
}