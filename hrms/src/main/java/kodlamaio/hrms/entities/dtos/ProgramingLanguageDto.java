package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public class ProgramingLanguageDto {
	private int jobSeekerId;
	private int progLanguageId;
	private String planguageName;
	private int plevel;
}
