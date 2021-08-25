package kodlamaio.hrms.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.HrmsVerification;

public interface HrmsVerificationDao extends JpaRepository <HrmsVerification,Integer> {

}
