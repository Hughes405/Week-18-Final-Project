package com.pie_shop.pies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pie_shop.pies.entity.Pie;
import com.pie_shop.pies.services.PieService;

@RestController
@RequestMapping("/pie_shop/pies")
public class PieController {
	private PieService pieService;

	public PieController(PieService pieService) {
		super();
		this.pieService = pieService;
	}

	@GetMapping
	public List<Pie> getAllPies() {
		return pieService.getAllPies();
	}

}
