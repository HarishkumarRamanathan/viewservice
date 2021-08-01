package com.example.view.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.view.model.viewModel;
import com.example.view.service.ViewService;

@RestController
@RequestMapping("/view")
public class ViewController {

	@Autowired
	private ViewService viewService;
	
	@GetMapping("/index")
	public String get() {
		return "Welcome View Service";
		
	}
	
	@GetMapping("/vieworder")
	public Collection<viewModel> viewOrders(){
		
		return viewService.viewOrders();
		
	}
}
