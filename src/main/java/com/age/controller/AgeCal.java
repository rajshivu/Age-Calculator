package com.age.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgeCal {
	
	@GetMapping("/age")
	public String get(Model model) {
		model.addAttribute("age", new Entity());
		return "age";
	}
	@PostMapping("/age/save")
    public String out(@ModelAttribute("age") Entity e, Model model) {
        int b_day = e.getDay();
        int b_month = e.getMonth();
        int b_year = e.getYear();
        
        LocalDate birthDate = LocalDate.of(b_year, b_month, b_day);
        LocalDate currentDate = LocalDate.now();
        
        Period period = Period.between(birthDate, currentDate);
        int day = period.getDays();
        int month = period.getMonths();
        int year = period.getYears();
        
        Entity calculatedAge = new Entity();
        calculatedAge.setDay(day);
        calculatedAge.setMonth(month);
        calculatedAge.setYear(year);
        
        model.addAttribute("c", calculatedAge);
        
        return "age";
    }
	
	

}
