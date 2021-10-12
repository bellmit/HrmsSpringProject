package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class JobExperienceDto {
	private int jobSeekerId;
	private String companyName;
	private boolean stillWork;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endedDate;

}
