package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="coverLetters")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "HybernateLazyInitializer", "handler", "jobAdvertisements" })
//@PrimaryKeyJoinColumn(name="coverLetterId")
public class CoverLetter {
	@Id
	@Column(name="coverLetterId")
	private int coverLetterId;
	
	@Column(name="text")
	private String text;
	
	@JoinColumn(name = "job_seeker_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@JoinColumn(name = "cv_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CurriculumVitae curriculumVitae;
}
