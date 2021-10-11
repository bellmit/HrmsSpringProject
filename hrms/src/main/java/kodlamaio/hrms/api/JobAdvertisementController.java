package kodlamaio.hrms.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/JobAdvertisement")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController (JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService=jobAdvertisementService;
	}
	
	@PostMapping("/save")
	public Result save(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.save(jobAdvertisement);
	}
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);	
	}
	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return  this.jobAdvertisementService.delete(jobAdvertisement);	
	}
	
	@GetMapping("/getAllActiveJobAdvertisements")
	public DataResult<List<JobAdvertisementService>> getByActiveJobAdvertisements(){
		return (DataResult) this.jobAdvertisementService.getByActiveJobAdvertisements();
	}
	@GetMapping("/getAllReleaseDateDesc")
	public DataResult<List<JobAdvertisement>> getBylReleaseDateDesc() {
		return (DataResult) this.jobAdvertisementService.getByReleaseDateDesc();
	}
	@GetMapping("/getAllApplicationDeadlineDesc")
	public DataResult<List<JobAdvertisement>> getAllApplicationDeadlineDesc() {
		return (DataResult) this.jobAdvertisementService.getAllApplicationDeadlineDesc();	
	}
	
	@GetMapping("/getAllActiveJobAdvertisementByEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployer_CompanyName(String companyName) {
		return (DataResult) this.jobAdvertisementService.getByIsActiveJobAdvertisementAndEmployer_CompanyName(true, companyName);	
	}
	@GetMapping("setJobAdvertisementStatus")
	public Result setJobAdvertisementStatus(int id) {
		return (Result) this.setJobAdvertisementStatus(id);
	}
	
	
	
	
	
	
}
