package com.pie_shop.pies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pie_shop.pies.entity.Pie;
import com.pie_shop.pies.repository.PieRepository;

@Service
public class PieServiceImp implements PieService{
private PieRepository pieRepository;
	
	@Autowired
	public PieServiceImp(PieRepository pieRepository) {
		this.pieRepository = pieRepository;
		
	}

	@Override
		public List<Pie> getAllPies(){
	    return pieRepository.findAll();
		 
	}

}
