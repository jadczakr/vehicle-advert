package advertisement.vehicle.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import advertisement.vehicle.entities.Motorcycle;
import advertisement.vehicle.service.implementation.MotorcycleServiceImpl;

@Controller
public class MotorcycleController {


	private MotorcycleServiceImpl motorcycleServiceImpl;
	
	
	public MotorcycleController(MotorcycleServiceImpl motorcycleServiceImpl)
	{
		this.motorcycleServiceImpl = motorcycleServiceImpl;
	}
	
	
	@RequestMapping(value = "/save-moto" , method = RequestMethod.POST)
	private String saveMoto(HttpServletRequest request, @ModelAttribute("tempMoto")Motorcycle tempMoto)
	{
		motorcycleServiceImpl.saveOrUpdateMotorcycle(tempMoto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/motocykle" , method = RequestMethod.GET)
	private String motorcycleList(Model theModel)
	{
		
		theModel.addAttribute("motorcycles",motorcycleServiceImpl.getMotorcycleList());
		
		return "motocykle";
		
	}
}
