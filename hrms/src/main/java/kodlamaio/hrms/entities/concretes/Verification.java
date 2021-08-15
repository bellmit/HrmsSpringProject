package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="verification")
@AllArgsConstructor
@NoArgsConstructor
public class Verification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="verification_id")
	private int verificationId;
	
	@Column(name="email_verification")
	private boolean emailVerification;
	
	@Column(name="system_verification")
	private boolean systemVerification;
	
	@Column(name="mernis_verification")
	private boolean mernisVerification;
}
