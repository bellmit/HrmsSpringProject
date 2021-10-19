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
	private String identityNumber;//JobSeeker
	private String firstName;//JobSeeker
	private String lastName;//JobSeeker
	private String imageUrl;//Image
	private String schoolName;//School
	private String departmant;//School	
	private Date startDate;//School
	private Date graduationYear;//School
	private String planguageName;//ProgramingLanguage
	private int plevel;//ProgramingLanguage
	private String flanguageName;//ForeignLangauge
	private int level;//ForeignLangauge
	private String text;//CoverLetter
	private String socialUrl;//SocialLink
	private boolean isStillWork;//jobExperience
	private Date startedDate;//JobExperience
	private Date endedDate;//JobExperience
	private String companyName;//JobExperience
	private String cityName;//City
	
}
