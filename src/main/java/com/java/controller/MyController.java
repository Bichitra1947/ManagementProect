package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.entity.Laptop;
import com.java.repository.LaptopRepository;
import com.java.service.LaptopService;

@Controller
public class MyController {

	@Autowired
	private LaptopRepository repository;
	
	@Autowired
	private LaptopService service;
	
	@GetMapping("/")
	public ModelAndView formPage() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("Laptop", repository.findAll());
		mav.setViewName("showData");
		return mav;
	}
	
	@GetMapping("/index")
	public ModelAndView indexPage() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("laptop", new Laptop());
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/form")
	public ModelAndView saveData( Laptop laptop) {
		ModelAndView mav=new ModelAndView();
		
		Boolean status = service.saveRecords(laptop);
		mav.setViewName("index");
		if(status) {
			mav.addObject("data1" ,"Your Records is successfully added");
		}else {
			mav.addObject("data2" ,"Failed to save data");
		}
		return mav;
	}
	
	// delete the records--------------------------------------------------
	
	@GetMapping("/delete")
	public ModelAndView getDeleteData(@RequestParam("laptopId") Integer id) {
		ModelAndView mav=new ModelAndView();
		service.deleteData(id);
		System.out.println(id);
		mav.setViewName("deleteSuccess");
		if(id!=null) {
			mav.addObject("msg1", "delete Success");
		}else {
			mav.addObject("msg2", "delete Success");
		}
		return mav;
	}
	// update the existing data ---------------------------------------
	@GetMapping("/edit")
	public ModelAndView getEditData(@RequestParam("ID") Integer id) {
		Laptop laptop = service.editData(id);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("laptops", laptop);
		mav.setViewName("update");
		return mav;
	}
	
	
	
	
	
}

















