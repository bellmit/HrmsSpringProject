package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDto;

@RestController
@RequestMapping("/api/ForeignLanguage")
public class ForeignLanguageController {
	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
		this.foreignLanguageService = foreignLanguageService;
	}

	@PostMapping("/save")
	public Result save(@RequestBody ForeignLanguageDto foreignLanguageDto) {
		return this.foreignLanguageService.save(foreignLanguageDto);
	}
	/*
	 * @GetMapping("/{jobId}") public JobPosition getById(@PathVariable("jobId")
	 * Integer jobId){ return this.jobPositionService.getById(jobId); }
	 */

}
