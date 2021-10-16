package kodlamaio.hrms.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

public interface CityDao extends JpaRepository <City, Integer>  {
	City getById(int id);
	
	City findByCityName(String cityName);
}
