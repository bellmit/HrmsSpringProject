package kodlamaio.hrms.core.utilities.results;

import java.util.List;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

public class SuccessDataResult<T> extends DataResult<T> {

	
	public SuccessDataResult(T data,String message) {
		super(data, true, message);	
	}
	public SuccessDataResult(T data) {
		super(data,true);
	}
	public SuccessDataResult(String message) {
		super(null,true,message);
	}
	
	

	

}
