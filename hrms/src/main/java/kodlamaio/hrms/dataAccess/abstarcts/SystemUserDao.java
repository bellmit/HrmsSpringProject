package kodlamaio.hrms.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemUser;

public interface SystemUserDao extends JpaRepository<SystemUser,Integer> {
	SystemUser findByEmail(String email);
	
}
