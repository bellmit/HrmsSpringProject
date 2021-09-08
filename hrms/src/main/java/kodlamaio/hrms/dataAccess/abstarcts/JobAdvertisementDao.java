package kodlamaio.hrms.dataAccess.abstarcts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> findByIsActiveAndJobPosition(boolean isActive, String jobPosition);
	
	List<JobAdvertisement> findByReleaseDateOrderByReleaseDateDesc(Date releaseDate);
	
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getByActiveJobAdvertisements();
	
	@Query("From JobAdvertisement where isActive=true Order By releaseDate")
	
	List<JobAdvertisement> getByReleaseDateDesc();
	
	@Query("From JobAdvertisement where isActive=true Order By ApplicationDeadline")
	List<JobAdvertisement> getAllApplicationDeadlineDesc();
	
	//@Query("From JobAdvertisement where isActive = true and employer.companyName=:companyName") 
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	
}
