package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "foreign_languages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "HybernateLazyInitializer", "handler", "products" })
public class ForeignLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foreign_language_id")
	private int foreignLanguageId;

	@Column(name = "flanguage_name")
	private String flanguageName;

	@Column(name = "level")
	private int level;

	@JoinColumn(name = "job_seeker_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private JobSeeker jobSeeker;

	@JoinColumn(name = "cv_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CurriculumVitae curriculumVitae;

}
