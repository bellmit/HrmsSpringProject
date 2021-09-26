package kodlamaio.hrms.entities.concretes;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HybernateLazyInitializer","handler","products"})

public class JobPosition{
	@Id
	@GeneratedValue
	@Column(name="position_id")
	private int id;
	

	@Column(name="title", unique=true,nullable=false)
	private String title;
	
	@OneToMany(mappedBy = "jobPosition")//
	private List<JobAdvertisement> jobAdvertisements;	

}
