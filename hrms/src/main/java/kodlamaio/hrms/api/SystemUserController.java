package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/SystemUserController")
public class SystemUserController {
	private SystemUserService systemUserService;

	@Autowired
	public SystemUserController(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll() {
		return this.systemUserService.getAll();
	}

	@PostMapping("/add")
	public Result add(SystemUser systemUser) {
		return this.systemUserService.add(systemUser);
	}

	@PostMapping("/delete")
	public Result delete(SystemUser systemUser) {
		return this.systemUserService.delete(systemUser);
	}

}
