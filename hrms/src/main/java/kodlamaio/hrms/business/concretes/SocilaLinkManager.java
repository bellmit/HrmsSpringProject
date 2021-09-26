package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kodlamaio.hrms.business.abstracts.SocialLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.SocialLinkDao;
import kodlamaio.hrms.entities.concretes.SocialLink;
import kodlamaio.hrms.entities.dtos.SocialLinkDto;

@Service
public class SocilaLinkManager implements SocialLinkService {
	
	private SocialLinkDao socialLinkDao;
	
	private ModelMapper modelMapper;
	
	@Autowired
	public SocilaLinkManager(ModelMapper modelMapper,SocialLinkDao socialLinkDao) {
		super();
		this.modelMapper = modelMapper;
		this.socialLinkDao = socialLinkDao;
	}
	
	@Override
	public Result add(SocialLinkDto socialLinkDto) {
		SocialLink socialLink = modelMapper.map(socialLinkDto,SocialLink.class);
		// JobSeekerId si var mı diye kontrol et sonra kaydet.
		socialLinkDao.save(socialLink);
		return new SuccessResult("Saved successfully");
	}

	@Override
	public DataResult<List<SocialLinkDto>> getByJobSeekerId(int jobSeekerId) {
		
		return null;
	}

}
