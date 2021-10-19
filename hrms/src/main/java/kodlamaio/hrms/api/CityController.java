package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CityDto;

@RestController
@RequestMapping("/api/City")
public class CityController {
	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@PostMapping("/save")
	public Result save(@RequestBody CityDto cityDto) {
		return this.cityService.save(cityDto);
	}
	@GetMapping("/getAll")
	public DataResult<List<CityDto>> getAll() {
		return this.cityService.getAll();
	}

}
