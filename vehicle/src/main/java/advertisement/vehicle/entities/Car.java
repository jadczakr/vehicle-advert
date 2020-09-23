package advertisement.vehicle.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity(name="car")
@JsonIgnoreProperties
public class Car {

	
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

	@Column(name="uncrashed")
	private boolean uncrashed;
	
	@Column(name="gearbox")
	private String gearbox;
	
	@Column(name="drive")
	private String drive;
	
	@Column(name="registered")
	private boolean registered;
	
	@Column(name="additional_equipment")
	private String additionalEquipment;

	@Column(name="overseas")
	private String overseas;
	
	@Column(name="header")
	private String header;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="type")
	private String type;
	
	@Column(name="city")
	private String city;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private Integer phone;
	
	@Column(name="email")
	private String email;

	@Column(name="photos_path")
	private String photosPath;
	
	@ColumnDefault("false")
	@Column(name="visible")
	private boolean visible;
	
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getPhotosPath() {
		
		return photosPath;
	}

	public void setPhotosPath(String photosPath) {
		this.photosPath = photosPath;
	}

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="advertisement_id")
	public Advertisement advertisement;
	

	
	public String getOnlyCity()
	{
		return this.city.split(",")[0];
	}
	
	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
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

	public String getName2() {

		if(!name.isEmpty())
		{
			char p = name.charAt(0);
			name = Character.toString(p).toUpperCase() + name.substring(1,name.length());
			return name;
		}
		else
		{
			return "";
		}
		
		
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

	public String getPhoneString() {
		
		String tempPhone;
		tempPhone = phone.toString();
		
		if(tempPhone.length()==9)
		{
			tempPhone = "+48 " + tempPhone.substring(0,3) + " " + tempPhone.substring(3,6) + " " + tempPhone.substring(6,9);
		}
		
		return tempPhone;
	}

	public boolean isFirstPhoto(String path)
	{
		if(photosPath.split(";")[0].equals(path))
			return true;
		else 
			return false;
	}
	
	public String functionSinglePhoto()
	{
		String[] array = photosPath.split(";");
		
		return array[0];

		
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

	public Integer getId() {
		return id;
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

	public boolean isUncrashed() {
		return uncrashed;
	}

	public void setUncrashed(boolean uncrashed) {
		this.uncrashed = uncrashed;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
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

	public Car() {
	
	}

	public Car(String mark, String model, Integer prodYear, String description, Integer mileage, String fuel,
			Integer engine, Integer horsepower, String condition, boolean uncrashed, String color, String gearbox,
			String drive, boolean registered, String additionalEquipment) {
		super();
		this.mark = mark;
		this.model = model;
		this.prodYear = prodYear;
		this.description = description;
		this.mileage = mileage;
		this.fuel = fuel;
		this.engine = engine;
		this.horsepower = horsepower;
		this.uncrashed = uncrashed;
		this.gearbox = gearbox;
		this.drive = drive;
		this.registered = registered;
		this.additionalEquipment = additionalEquipment;
	}

	@Override
	public String toString() {
		return "Car [mark=" + mark + ", model=" + model + ", prodYear=" + prodYear + ", description=" + description
				+ ", mileage=" + mileage + ", fuel=" + fuel + ", engine=" + engine + ", horsepower=" + horsepower
				+ ", uncrashed=" + uncrashed + ", gearbox=" + gearbox + ", drive=" + drive + ", registered="
				+ registered + ", additionalEquipment=" + additionalEquipment + ", overseas=" + overseas + ", header="
				+ header + ", price=" + price + ", type=" + type + ", city=" + city + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", photosPath=" + photosPath + ", visible=" + visible
				+ ", advertisement=" + advertisement + "]";
	}
	
	
	
	
	
}
