package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"HybernateLazyInitializer","handler","products"})
@Table(name="programing_languages")
public class ProgramingLanguage {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="prog_language_id")
		private int progLanguageId;
		
		@Column(name="planguage_name")
		private String planguageName;
		
		@Column(name="plevel")
		private int plevel;
		
		@JoinColumn(name="job_seeker_id")
		@ManyToOne(fetch = FetchType.LAZY)
		private JobSeeker jobSeeker;
		
		@JoinColumn(name="cv_id")
		@ManyToOne(fetch = FetchType.LAZY)
		private CurriculumVitae curriculumVitae;
		
	}

