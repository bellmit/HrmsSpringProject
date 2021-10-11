package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.SocialLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import kodlamaio.hrms.entities.dtos.SocialLinkDto;

@RestController
@RequestMapping("/api/SocialLink")
public class SocialLinkController {
	
	@Autowired
	private SocialLinkService socialLinkService;

	
	public SocialLinkController(SocialLinkService socialLinkService) {
		super();
		this.socialLinkService = socialLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialLinkDto socialLinkDto) {
		return this.socialLinkService.add(socialLinkDto);
	}
	@GetMapping("/getAll")
	public DataResult<List<SocialLinkDto>> getAll() {
		return this.socialLinkService.getAll();
	}
	
	
}
