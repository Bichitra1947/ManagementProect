package com.java.service;

import java.util.List;


import com.java.entity.Laptop;


public interface LaptopService {
	public List<Laptop> getAllData();
	public Boolean saveRecords(Laptop laptop);
	public void deleteData(Integer id); 
	public Laptop editData(Integer id);
}
