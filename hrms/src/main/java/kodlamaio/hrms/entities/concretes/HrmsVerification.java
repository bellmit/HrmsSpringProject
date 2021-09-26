package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HybernateLazyInitializer","handler","products"})
@Table(name="hrms_verification")
public class HrmsVerification {
	@Id
	@Column(name="verification_id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="system_user_id")
	private int personelId;
	
	@Column(name="is_verify")
	private boolean isVerify;

}
