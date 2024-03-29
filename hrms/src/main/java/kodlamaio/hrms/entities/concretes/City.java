package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "city")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "HybernateLazyInitializer", "handler", "jobAdvertisements" })
//@PrimaryKeyJoinColumn(name = "city_id")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_name")
	private String cityName;

	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id")
	private CurriculumVitae curriculumVitae;
	
	@JoinColumn(name = "job_seeker_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private JobSeeker jobSeeker;
	
}
