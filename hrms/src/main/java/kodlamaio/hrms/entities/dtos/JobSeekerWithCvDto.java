package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerWithCvDto {
	private int cvId;//CirriculumVitae
	private String IdentityNumber;//js
	private String firstName;//jseeker
	private String lastName;//js
	private String imageUrl;//Image
	private String schoolName;//School
	private String departmant;//School	
	private Date startDate;//School
	private Date graduationYear;//School
	private String planguageName;//programingLanguage
	private int plevel;//programingLanguage
	private String flanguageName;//ForeignLangauge
	private int flevel;//ForeignLangauge
	private String coverLetter;//CirriculumVitae
	private String githupLink;//CirriculumVitae
	private String linkedlnLink;//CirriculumVitae
	private boolean isStillWork;//jobExperience
	private Date startedDate;//jobExperience
	private Date endedDate;//jobExperience
	private String companyName;//jobExperience
	
}
