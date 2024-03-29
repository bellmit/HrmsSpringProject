package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/JobPosition")
public class JopPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JopPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionService.getAll();

	}

	@GetMapping("/{jobId}")
	public JobPosition getById(@PathVariable("jobId") Integer jobId) {
		return this.jobPositionService.getById(jobId);

	}

	@PostMapping("/save")
	public Result save(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.save(jobPosition);
	}
}
