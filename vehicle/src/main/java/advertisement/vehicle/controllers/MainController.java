package advertisement.vehicle.controllers;

import java.io.IOException; 
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import advertisement.vehicle.entities.Advertisement;
import advertisement.vehicle.entities.Car;
import advertisement.vehicle.entities.Motorcycle;
import advertisement.vehicle.helpers.utils;
import advertisement.vehicle.service.implementation.AdvertisementServiceImpl;
import advertisement.vehicle.service.implementation.CarServiceImpl;
import advertisement.vehicle.service.implementation.MotorcycleServiceImpl;

@Controller
public class MainController {

	
	private MotorcycleServiceImpl motorcycleServiceImpl;
	private CarServiceImpl carServiceImpl;
	private AdvertisementServiceImpl advertisementServiceImpl;
	
	public MainController(MotorcycleServiceImpl motorcycleServiceImpl, CarServiceImpl carServiceImpl, AdvertisementServiceImpl advertisementServiceImpl)
	{
		this.motorcycleServiceImpl = motorcycleServiceImpl;
		this.carServiceImpl = carServiceImpl;
		this.advertisementServiceImpl = advertisementServiceImpl;
	}
	
	
	@RequestMapping(value = "/nowe-ogloszenie")
	private String addVehivle(Model theModel)
	{
		theModel.addAttribute("tempCar",new Car());
		theModel.addAttribute("tempMoto",new Motorcycle());
		
		return "add";
	}
	
	@RequestMapping(value = "/")
	private String mainStart(Model theModel)
	{
		
		theModel.addAttribute("cars",carServiceImpl.findLastTenRows());
		
		return "home";
	}
	
	
	
	@RequestMapping("/mail")
	public String sendEmail() throws IOException
	{
		utils.sendActivationMail("jadczakr@edc.expert",carServiceImpl.getCarByAdvertisementNumb(38));
		
		return "";
	}
	
	@RequestMapping(value = "/ogloszenie/{id}")
	private String getAdvert(@PathVariable("id")Integer id, Model theModel)
	{
		
		Optional<Advertisement> advert = advertisementServiceImpl.findById(id);
		
		
		
		
		if(advert.isPresent())
		{
			if(advert.get().getType().equals("car"))
			{
				Car tempCar = carServiceImpl.getCarByAdvertisementNumb(id);
				
				if(tempCar!=null)
				{
					
					Car tempCar2 = carServiceImpl.getPhotosByAdvertisementId(id);
					if(tempCar2!=null)
					{
						if(tempCar2.getPhotosPath()!=null)
						{
							theModel.addAttribute("photos",tempCar.getPhotosPath().split(";"));
						}
						
					}
					
					
					List<String> tempList = Arrays.asList(carServiceImpl.wyposazenieDodatkowe(id).get(0).split(";"));
					System.out.println(tempList.get(0).isEmpty());;
					System.out.println(tempList.get(0).isEmpty());;
					System.out.println(tempList.get(0).isEmpty());;
					System.out.println(tempList.get(0).isEmpty());;
					System.out.println(tempList.get(0).isEmpty());;
					System.out.println(tempList.get(0).isEmpty());;
					System.out.println(tempList.get(0).isEmpty());;
					System.out.println(tempList.get(0).isEmpty());;
					theModel.addAttribute("additionalEq",tempList);
					theModel.addAttribute("car",tempCar);
					return "car-details";
				}
				
			}
			else if(advert.get().getType().contentEquals("moto"))
			{
				Motorcycle tempMoto = motorcycleServiceImpl.getMotorcycleByAdvertisementNumb(id);
				
				if(tempMoto!=null)
				{
					theModel.addAttribute("moto",tempMoto);
					return "moto-details";
				}
			}
		}
		else
		{
			theModel.addAttribute("active","brak");
			return "aktywacja";
		}
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/o-mnie")
	public String omnie()
	{
		return "omnie";
	}
	
}
