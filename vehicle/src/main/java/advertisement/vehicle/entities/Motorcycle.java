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
@Entity(name="motorcycle")
public class Motorcycle{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="mark")
	private String mark;
	
	@Column(name="model")
	private String model;
	
	@Column(name="prod_year")
	private Integer prodYear;
	
	@Column(name="description")
	private String description;
	
	@Column(name="mileage")
	private Integer mileage;
	
	@Column(name="fuel")
	private String fuel;
	
	@Column(name="engine")
	private Integer engine;
	
	@Column(name="horsepower")
	private Integer horsepower;
	
	@Column(name="condition")
	private String condition;
	
	@Column(name="uncrashed")
	private boolean uncrashed;
	
	@Column(name="color")
	private String color;
	
	@Column(name="type")
	private String type;
	
	@Column(name="registered")
	private boolean registered;
	
	@Column(name="additional_equipment")
	private String additionalEquipment;
	
	@Column(name="gearbox")
	private String gearbox;
	
	@Column(name="drive")
	private String drive;
	
	@Column(name="overseas")
	private String overseas;
	
	@Column(name="header")
	private String header;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="city")
	private String city;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private Integer phone;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="advertisement_id")
	private Advertisement advertisement;	
	

	
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getOverseas() {
		return overseas;
	}

	public void setOverseas(String overseas) {
		this.overseas = overseas;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getProdYear() {
		return prodYear;
	}

	public void setProdYear(Integer prodYear) {
		this.prodYear = prodYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Integer getEngine() {
		return engine;
	}

	public void setEngine(Integer engine) {
		this.engine = engine;
	}

	public Integer getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean isUncrashed() {
		return uncrashed;
	}

	public void setUncrashed(boolean uncrashed) {
		this.uncrashed = uncrashed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public String getAdditionalEquipment() {
		return additionalEquipment;
	}

	public void setAdditionalEquipment(String additionalEquipment) {
		this.additionalEquipment = additionalEquipment;
	}

	public Motorcycle(String mark, String model, Integer prodYear, String description, Integer mileage, String fuel,
			Integer engine, Integer horsepower, String condition, boolean uncrashed, String color, boolean registered,
			String additionalEquipment) {
		super();
		this.mark = mark;
		this.model = model;
		this.prodYear = prodYear;
		this.description = description;
		this.mileage = mileage;
		this.fuel = fuel;
		this.engine = engine;
		this.horsepower = horsepower;
		this.condition = condition;
		this.uncrashed = uncrashed;
		this.color = color;
		this.registered = registered;
		this.additionalEquipment = additionalEquipment;
	}

	public Motorcycle() {
	
	}

	
	
	
}
