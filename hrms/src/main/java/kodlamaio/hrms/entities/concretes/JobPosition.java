package kodlamaio.hrms.entities.concretes;

import java.lang.annotation.Annotation;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor

public class JobPosition{
	@Id
	@GeneratedValue
	@Column(name="position_id")
	private int id;
	
	@Column(name="title")
	private String title;

	
	

}
