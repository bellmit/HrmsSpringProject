package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgramingLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;
import kodlamaio.hrms.entities.dtos.ProgramingLanguageDto;

@RestController
@RequestMapping("/api/ProgramingLanguage")
public class ProgramingLanguageController {
	private ProgramingLanguageService programingLanguageService;

	@Autowired
	public ProgramingLanguageController(ProgramingLanguageService programingLanguageService) {
		this.programingLanguageService = programingLanguageService;
	}
	@PostMapping("/save")
	public Result save(@RequestBody ProgramingLanguageDto programingLanguageDto) {
		return this.programingLanguageService.save(programingLanguageDto);
	}

	@GetMapping("/{jobSeekerId}")
	public DataResult<List<ProgramingLanguageDto>> getByJobSeekerId(@PathVariable("jobSeekerId") int jobSeekerId){
		return this.programingLanguageService.getByJobSeekerId(jobSeekerId);
	}
	
	
	
}
