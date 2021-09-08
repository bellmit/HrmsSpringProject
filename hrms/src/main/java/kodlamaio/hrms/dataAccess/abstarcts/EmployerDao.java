package kodlamaio.hrms.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

public interface EmployerDao extends JpaRepository <Employer,Integer> {
	Employer findByEmail(String email);

	Employer findByCompanyName(String companyName);
	
	
	
}
