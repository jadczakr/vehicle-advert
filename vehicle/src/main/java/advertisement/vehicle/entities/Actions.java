package advertisement.vehicle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity(name="actions")
public class Actions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="key")
	private String key;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="advertisement_id")
	private Advertisement advertisement;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public Advertisement getAdvertisement() {
		return advertisement;
	}


	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}


	public Actions(Integer id, String key, Advertisement advertisement) {
		super();
		this.id = id;
		this.key = key;
		this.advertisement = advertisement;
	}
	
	
	public Actions()
	{
		
	}
	
}
