package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class JobAdvertisementDto {
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private boolean isActive=false;
	private String jobDefination;
	private int numberOfOpenPosition;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applicationDeadline;
	private int maxSalary;
	private int minSalary;
	
}
