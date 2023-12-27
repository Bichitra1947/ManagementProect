package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.entity.Laptop;
import com.java.repository.LaptopRepository;

@Service
public class LaptopServiceImplement implements LaptopService {

	private LaptopRepository repository;
	
	@Autowired
	public void setRepository(LaptopRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Laptop> getAllData() {
		List<Laptop> list = repository.findAll();
		list.forEach(System.out::println);
		return list;
	}

	@Override
	public Boolean saveRecords(Laptop laptop) {
		Laptop laptop2 = repository.save(laptop);
		if(laptop2!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public void deleteData(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public Laptop editData(Integer id) {

		Optional<Laptop> optional = repository.findById(id);
		Laptop laptop = optional.get();
		 return laptop;
	}

}
