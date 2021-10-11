package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HybernateLazyInitializer","handler","products"})
@PrimaryKeyJoinColumn(name="job_seeker_id",referencedColumnName = "id")

public class JobSeeker extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number",unique=true)
	private String identityNumber;
	
	@Column(name="birth_of_year")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birtOfYear;

	@Column(name="is_verify")
	private boolean isVerify; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cvId")
	private CurriculumVitae curriculumVitae;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<School> schools;
	
	/*@OneToMany(mappedBy="jobSeeker")
	private List<SocialLink> socialLinks;*/
	
	
	
	
	
}
