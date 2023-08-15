package com.electronics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.entity.LapTop;
import com.electronics.service.LapTopService;

@RestController
public class LapTopController {
	
	@Autowired
	LapTopService lapTopService;
	@PostMapping (value ="/set1")
	public String setLap(@RequestBody LapTop lapTop) {
		return lapTopService.setLap(lapTop);
	}
	
	@PostMapping (value ="/setAll")
	public String setAllLap(@RequestBody List<LapTop> lapTop) {
		return lapTopService.setAllLap(lapTop);
	}
	@GetMapping("/getById/{id}")
	public LapTop getById(@PathVariable int id) {
		
		return lapTopService.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<LapTop> getAll() {
		
		return lapTopService.getAll();
	}
	@GetMapping("/getBrandByprice/{price}")
	public List<LapTop> getBrandByPrice(@PathVariable("price") int price) {
		return lapTopService.getBrandByPrice(price);
	}
	
	@GetMapping("/getBrandAloneByprice/{price}")
	public List<String> getBrandAloneByPrice(@PathVariable("price") int price) {
		return lapTopService.getBrandAloneByPrice(price);
	}
	
	@GetMapping("/getByRange/{price1}/{price2}")
	public List<LapTop> getByRange(@PathVariable ("price1") int price1,@PathVariable("price2") int price2){
		return lapTopService.getByRange(price1,price2);
		
	}
	
	@GetMapping("/getByMax")
	public LapTop getByMax(){
		return lapTopService.getByMax();
		
	}
	
	@PutMapping("/getByAdd")
	public String getByAdd(){
		return lapTopService.getByAdd();
		
	}
	
	
	

}
