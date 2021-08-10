package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="verification")
public class Verification {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="email_verification")
	private boolean emailVerification;
	
	@Column(name="system_verification")
	private boolean systemVerification;
	
	@Column(name="mernis_verification")
	private boolean mernisVerification;
}
