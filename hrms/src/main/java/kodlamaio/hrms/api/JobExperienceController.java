package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@RestController
@RequestMapping("/api/JobExperience")
public class JobExperienceController {
	private JobExperienceService jobExperienceService;

	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}

	@PostMapping("/save")
	Result save(@RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.save(jobExperienceDto);

	}

	@GetMapping("/getAll")
	DataResult<List<JobExperienceDto>> getAll() {
		return this.jobExperienceService.getAll();
	}

}
