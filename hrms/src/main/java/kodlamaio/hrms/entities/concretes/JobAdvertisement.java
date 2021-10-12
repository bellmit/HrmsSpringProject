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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "jobAdvertisements")
@JsonIgnoreProperties({ "HyberbernateLazyInitializer", "handler", "employer" })
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int jobAdvertisementId;

	@Column(name = "job_defination", nullable = false)
	private String jobDefination;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "number_of_open_position", nullable = false)
	private int numberOfOpenPosition;

	@Column(name = "release_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;

	@Column(name = "application_deadline")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applicationDeadline;

	@Column(name = "is_active")
	private boolean isActive = false;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "position_id")
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

}
