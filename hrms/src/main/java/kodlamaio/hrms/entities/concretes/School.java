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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="departmant")
	private String departmant;
	
	@Column(name="startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Column(name="graduation_year")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date graduationYear;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JoinColumn(name="cv_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CurriculumVitae curriculumVitae;
	
	
	
	
}
