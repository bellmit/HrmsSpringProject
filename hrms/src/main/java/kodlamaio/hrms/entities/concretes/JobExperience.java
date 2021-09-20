package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="experience_id")
	private int experienceId;
	
	@Column(name="is_still_work")
	private boolean isStillWork=false;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="start_date")
	private Date startedDate;
	
	@Column(name="end_date")
	private Date endedDate;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JoinColumn(name="cv_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CurriculumVitae curriculumVitae;
	
}
