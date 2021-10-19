package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;

@RestController
@RequestMapping("/api/CoverLetter")
public class CoverLetterController {
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLetterController(CoverLetterService coverLetterService) {
		this.coverLetterService = coverLetterService;
	}
	@PostMapping("/save")
	public Result save(@RequestBody CoverLetterDto coverLetterDto) {
		return this.coverLetterService.save(coverLetterDto);
	}
	@PostMapping("/delete/{id}")
	public Result deleteById(@PathVariable int id) {
		return this.coverLetterService.deleteById(id);
	}
	@PostMapping("/update")
	public Result update(@RequestParam int jobSeekerId,@RequestParam String text) {
		return this.coverLetterService.update(jobSeekerId, text);
	}
	
}
