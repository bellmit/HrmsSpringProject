package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="Images")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HybernateLazyInitializer","handler","products"})
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="uploaded_date")
	private LocalDate uploadedDate=LocalDate.now();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JoinColumn(name="cv_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CurriculumVitae curriculumVitae;
	
	
}
