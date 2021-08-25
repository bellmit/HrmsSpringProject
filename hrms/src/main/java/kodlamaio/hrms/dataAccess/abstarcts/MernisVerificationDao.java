package kodlamaio.hrms.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.MernisVerification;

public interface MernisVerificationDao extends JpaRepository<MernisVerification,Integer>{
	
}
