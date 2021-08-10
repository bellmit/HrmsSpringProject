package kodlamaio.hrms.core.utilities.results;

public class DataResult<T> extends Result { //DataResult ın alacağı veri tipini <T> ile belirtip constructora ekliyoruz(T tipinde data diyerek) 
	//şu verilerin sonucunu almak istiyorum diyerek bu classı oluşturdum.
	
	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data=data;
		
	}
	public DataResult(T data, boolean success) {
		super(success);
		this.data=data;
	}
	public T getData() {
		return this.getData();
	}


}
