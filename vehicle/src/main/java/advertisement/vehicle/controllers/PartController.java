package advertisement.vehicle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import advertisement.vehicle.entities.Part;
import advertisement.vehicle.service.implementation.PartServiceImpl;

@Controller
public class PartController {

	
	
	private PartServiceImpl partServiceImpl;
	
	public PartController(PartServiceImpl partServiceImpl)
	{
		this.partServiceImpl = partServiceImpl;
	}
	
	
	
	
	@RequestMapping(value = "/czesci", method = RequestMethod.GET)
	private String getParts(Model theModel)
	{
		theModel.addAttribute("tempPart",new Part());
		return "czesci" ;
	}
	
	@RequestMapping(value = "/save-part", method = RequestMethod.POST)
	private String savePart(@ModelAttribute("tempPart")Part tempPart)
	{
		
		return "redirect:/";
	}
}
