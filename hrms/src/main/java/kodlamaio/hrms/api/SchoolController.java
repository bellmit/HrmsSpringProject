package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.School;
//import kodlamaio.hrms.entities.dtos.SchoolDto;
@RestController
@RequestMapping("/api/School")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@GetMapping("/getBySchoolName")
	public DataResult<List<School>> getBySchoolName(String schoolName){
		return this.schoolService.getBySchoolName(schoolName);	
	}
	
	@GetMapping("getByJobSeekerId")
	public DataResult<List<School>> getByJobSeekerId(int jobSeekerId)
	{
		return this.schoolService.getByJobSeekerId(jobSeekerId);
	}
	@PostMapping("/save")
	public Result save(@RequestBody School school) {
		return this.schoolService.save(school);
	}
	
	/*@GetMapping("/getSchoolDetails")
	public DataResult <List<SchoolDto>> getSchoolAll(){
		return this.schoolService.getSchoolDetails();
	}*/
	
	
}
