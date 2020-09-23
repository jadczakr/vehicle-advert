package advertisement.vehicle.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import advertisement.vehicle.entities.Advertisement;
import advertisement.vehicle.entities.Car;
import advertisement.vehicle.helpers.utils;
import advertisement.vehicle.service.implementation.AdvertisementServiceImpl;
import advertisement.vehicle.service.implementation.CarServiceImpl;
import java.util.*;  



@RestController
public class CarController {

	private AdvertisementServiceImpl advertisementServiceImpl;
	
	private CarServiceImpl carServiceImpl;
	
	public CarController(CarServiceImpl carServiceImpl, AdvertisementServiceImpl advertisementServiceImpl)
	{
		this.advertisementServiceImpl = advertisementServiceImpl;
		this.carServiceImpl = carServiceImpl;
	}

	
	@RequestMapping(value = "/save-car", method = RequestMethod.POST)
	private String addCar(HttpServletRequest request, @RequestParam(value="photos",required=false)MultipartFile[] files, @ModelAttribute("tempCar")Car tempCar) throws IOException
	{
		
		String email = request.getParameter("email");
		
		
		
		
		for(MultipartFile file : files)
		{
		
			try {
				String relativeWebPath = "/resources";
				String absoluteFilePath = request.getServletContext().getRealPath(relativeWebPath);
				
	
	
				byte[] bytes = file.getBytes();
				File dir = new File(absoluteFilePath);
				if(!dir.exists())
				{
					dir.mkdirs();
				}
				File uploadFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
				outputStream.write(bytes);
				outputStream.close();
				if(tempCar.getPhotosPath()==null)
						tempCar.setPhotosPath(uploadFile.getName());	
				else
						tempCar.setPhotosPath(tempCar.getPhotosPath() + ";" + uploadFile.getName());
				
				
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}

		}
		
		
		Advertisement advert = new Advertisement();
		advert.setEmail(email);
		advert.setExpData(LocalDate.now().plusMonths(1));
		advert.setExist(false);
		advert.setType("car");
		
		
		tempCar.setAdvertisement(advert);
		
		
		carServiceImpl.saveOrUpdateCar(tempCar);
		
		Optional<Car> tempC = carServiceImpl.getCarById(tempCar.getId());
		
		
		Car tempC2 = null;
		if(tempC.isPresent())
		{
			tempC2 = tempC.get();
		}

		utils.sendActivationMail(email,tempC2);

		
		return "redirect:/aktywacja-ogloszenia/";
	}
	
	@RequestMapping(value = "/aktywacja-ogloszenia/")
	public String aktywacja(Model theModel)
	{ 
		theModel.addAttribute("active","mail");
		return "aktywacja";
	}
	
	@RequestMapping(value = "/samochody",  method = RequestMethod.GET)
	private String getCars(Model theModel)
	{
		
		theModel.addAttribute("cars",carServiceImpl.getCarList());
		
		return "samochody";
	}
	
	@RequestMapping(value = "/active/{id}")
	private String activeAdvertisement(@PathVariable("id")Integer id, Model theModel)
	{
		
		Optional<Advertisement> advert = advertisementServiceImpl.findById(id);
		
		Advertisement presentAdvert;
		if(advert.isPresent())
		{
			presentAdvert = advert.get();
			
			if(presentAdvert.isActivated())
				theModel.addAttribute("active","aktywne");
			else
			{
				presentAdvert.setActivated(true);
			
				advertisementServiceImpl
						.saveOrUpdate(presentAdvert);
				
				theModel.addAttribute("id",id);
				
				theModel.addAttribute("active","aktywuje");
				theModel.addAttribute("id",advert.get().getId());
			}
		}
		else
		{
			theModel.addAttribute("active","brak");
		}
		
		
		
		return "aktywacja";
	}
	
	
	@GetMapping(value = "/samochody2")
	public List<Car> samochody()
	{
		
		return carServiceImpl.getCarList();
		
	}
	

	

	        
}

