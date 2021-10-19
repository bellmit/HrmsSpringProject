package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ImageDto;

public interface ImageService {
	Result save(ImageDto imageDto);
	
	Result update(ImageDto imageDto);
	
    Result delete(ImageDto imageDto);
	
}
