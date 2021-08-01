package kodlamaio.hrms.entities.concretes;

import java.lang.annotation.Annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_positions")
public class JobPosition{
	@Id
	@GeneratedValue
	@Column(name="position_id")
	private int id;
	
	@Column(name="title")
	private String title;

	public JobPosition() {
	}
	
	

}
