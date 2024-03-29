package kodlamaio.hrms.entities.concretes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "curriculum_vitae")//@Table(name = "Curriculum_vitae")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "HybernateLazyInitializer", "handler", "products" })
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;

	@OneToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<SocialLink> socialLinks;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<Image> images;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<School> schools;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguages;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<ProgramingLanguage> programingLanguages;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<JobExperience> jobExperiences;
	
	@OneToOne()
	@JoinColumn(name = "city_id")
	private City city;
	

}
