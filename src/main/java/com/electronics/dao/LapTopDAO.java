package com.electronics.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.entity.LapTop;
import com.electronics.repository.LapTopRepository;


@Repository
public class LapTopDAO {
	@Autowired
	LapTopRepository lapTopRepository;
	public String setLap(LapTop lapTop) {
		// TODO Auto-generated method stub
		lapTopRepository.save(lapTop);
		return "saved";
	}
	public String setAllLap(List<LapTop> lapTop) {
		// TODO Auto-generated method stub
		lapTopRepository.saveAll(lapTop);
		return "List of records saved successfully";
	}
	public LapTop getById(int id) {
		// TODO Auto-generated method stub
		return lapTopRepository.findById(id).get();
	}
	public List<LapTop> getAll() {
		// TODO Auto-generated method stub
		return lapTopRepository.findAll();
	}
	

}
