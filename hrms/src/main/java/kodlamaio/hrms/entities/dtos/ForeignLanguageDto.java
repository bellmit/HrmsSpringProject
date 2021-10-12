package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public class ForeignLanguageDto {
	private int jobSeekerId;
	private String flanguageName;
	private int level;
}
