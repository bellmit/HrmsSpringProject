package kodlamaio.hrms.entities.concretes;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="mernis_verification")
public class MernisVerification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="verification_id")
	private int id;
	
	@Column(name="job_seeker_id")
	private int seekerId;
	
	@Column(name="is_verify")
	private boolean isVerify;

}
