package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.SocialLinkDto;

public interface SocialLinkService {
	Result add(SocialLinkDto socialLinkDto);
	DataResult<List<SocialLinkDto>> getByJobSeekerId(int jobSeekerId);
}
