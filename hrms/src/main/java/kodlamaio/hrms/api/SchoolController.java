package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;

@RestController
@RequestMapping("/api/School")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@GetMapping("/getBySchoolNameStartsWith")
	public DataResult<List<SchoolDto>> getBySchoolNameStartsWith(String schoolName) {
		return this.schoolService.getBySchoolNameStartsWith(schoolName);
	}

	@GetMapping("getByJobSeekerId")
	public DataResult<List<School>> getByJobSeekerId(int jobSeekerId) {
		return this.schoolService.getByJobSeekerId(jobSeekerId);
	}

	@PostMapping("/save")
	public Result save(@RequestBody SchoolDto schoolDto) {
		return this.schoolService.save(schoolDto);
	}

	@GetMapping("/getAll")
	public DataResult<List<SchoolDto>> getAll() {
		return this.schoolService.getAll();
	}

}
