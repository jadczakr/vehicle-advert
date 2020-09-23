package advertisement.vehicle.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity(name="advertisement")
public class Advertisement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="type")
	private String type;
	

	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private Integer phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="exp_data")
	private LocalDate expdata;
	
	@Column(name="exist")
	private boolean exist;
	
	@Column(name="activated")
	private boolean activated;
	
	@OneToOne(mappedBy="advertisement")
	private Car car;
	

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	
	public LocalDate getExpData() {
		return expdata;
	}

	public void setExpData(LocalDate expData) {
		this.expdata = expData;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Advertisement(Integer id, String type, String name, Integer phone) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.phone = phone;
		
	}

	public Advertisement() {
	
	}
	
	public Advertisement(String type) {
		
	}
	
	
}
