package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SchoolDto {
	private int jobSeekerId;
	private String schoolName;
	private String departmant;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	private boolean isGraduated;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date graduationYear;
}
