package kodlamaio.hrms.business.concretes;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstarcts.CoverLetterDao;
import kodlamaio.hrms.dataAccess.abstarcts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;
import kodlamaio.hrms.entities.dtos.SchoolDto;

@Service
public class CoverLetterManager implements CoverLetterService{
	
	private CoverLetterDao coverLetterDao;
	private JobSeekerDao jobSeekerDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao, JobSeekerDao jobSeekerDao, ModelMapper modelMapper) {
		this.coverLetterDao = coverLetterDao;
		this.jobSeekerDao = jobSeekerDao;
		this.modelMapper = modelMapper;
	}
	@Override
	public Result save(CoverLetterDto coverLetterDto) {
		Optional<JobSeeker> jobSeeker=jobSeekerDao.findById(coverLetterDto.getJobSeekerId());
		if(jobSeeker.isPresent()) {
			CoverLetter coverLetter=modelMapper.map(coverLetterDto, CoverLetter.class);
			CoverLetter savedCoverLetter=this.coverLetterDao.save(coverLetter);
			return new SuccessDataResult(modelMapper.map(savedCoverLetter, CoverLetter.class));
		}else  {
			return new ErrorDataResult<>("JobSeeker is not present");
		}
	}
	@Override
	public Result update(int jobSeekerId, String text) {
		CoverLetter coverLetter=this.coverLetterDao.getByJobSeekerId(jobSeekerId);
		coverLetter.setText(text);
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Önyazı güncellendi");	
	}
	
	@Override
	public Result deleteById(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("önyazı silindi");
	}
}
