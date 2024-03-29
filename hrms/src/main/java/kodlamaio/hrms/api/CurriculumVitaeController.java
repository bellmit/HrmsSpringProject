package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.JobSeekerWithCvDto;

@RestController
@RequestMapping("/api/CurriculumVitae")
public class CurriculumVitaeController {
	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CurriculumVitae>> getAll() {
		return this.curriculumVitaeService.getAll();
	}

	@GetMapping("/JobSeekerWithCvDto")
	public DataResult<List<JobSeekerWithCvDto>> JobSeekerWithCvDto(Integer id) {
		return this.curriculumVitaeService.JobSeekerWithCvDto(id);
	}

	@GetMapping("/getByJobSeekerId")
	public DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId) {
		return this.curriculumVitaeService.getByJobSeekerId(jobSeekerId);
	}

	/*@GetMapping("/getAllJobSeekerIdSortedWithGraduationYear")
	public DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithGraduationYear(String ascOrDesc) {
		return this.curriculumVitaeService.getAllJobSeekerIdSortedWithGraduationYear(ascOrDesc);
	}

	@GetMapping("/getAllJobSeekerIdSortedWithEndedDate")
	public DataResult<CurriculumVitae> getAllJobSeekerIdSortedWithEndedDate(String ascOrDesc) {
		return this.curriculumVitaeService.getAllJobSeekerIdSortedWithEndedDate(ascOrDesc);
	}*/

}
