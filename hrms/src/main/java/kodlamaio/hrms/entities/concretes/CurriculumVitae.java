package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonIgnoreProperties({"HyberbernateLazyInitializer","handler","employer"})
@Table(name="Curriculum_vitae")
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@OneToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker; 
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="githup_link")
	private String githupLink;
	
	@Column(name="linkedln_link")
	private String linkedlnLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "curriculumVitae")
	private List<Image> images;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="curriculumVitae")
	private List<School> schools;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<ProgramingLanguage> programingLanguages;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<JobExperience> JobExperiences;
	
}
