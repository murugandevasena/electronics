package com.electronics.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.electronics.dao.LapTopDAO;
import com.electronics.entity.LapTop;

@Service
public class LapTopService {
	@Autowired
	LapTopDAO lapTopDAO;

	public String setLap(LapTop lapTop) {
		// TODO Auto-generated method stub
		return lapTopDAO.setLap(lapTop);
	}

	public String setAllLap(List<LapTop> lapTop) {
		// TODO Auto-generated method stub
		return lapTopDAO.setAllLap(lapTop);
	}

	public LapTop getById(int id) {
		// TODO Auto-generated method stub
		return lapTopDAO.getById(id);
	}

	public List<LapTop> getAll() {
		// TODO Auto-generated method stub
		return lapTopDAO.getAll();
	}

	public List<LapTop> getBrandByPrice(int price) {
		// TODO Auto-generated method stub
		List<LapTop> l1 = getAll();
		List<LapTop> l2 = l1.stream().filter(x -> x.getPrice() == price).collect(Collectors.toList());
		return l2;
	}

	public List<String> getBrandAloneByPrice(int price) {
		// TODO Auto-generated method stub
		List<LapTop> l3 = getAll();
		List<String> l4 = l3.stream().filter(x -> x.getPrice() == price).map(x -> x.getBrand())
				.collect(Collectors.toList());
		return l4;
	}

	public List<LapTop> getByRange(int price1, int price2) {
		// TODO Auto-generated method stub
		List<LapTop> l5 = getAll();
		List<LapTop> l6 = l5.stream().filter(x -> x.getPrice() >= price1 && x.getPrice() <= price2)
				.collect(Collectors.toList());
		return l6;
	}

	public LapTop getByMax() {
		// TODO Auto-generated method stub
		List<LapTop> l7 = getAll();
		LapTop l8 = l7.stream().max(Comparator.comparingInt(LapTop::getPrice)).get();
		return l8;
	}

	public String getByAdd() {
		// TODO Auto-generated method stub
		List<LapTop> l9 = getAll();
		l9.forEach(x->{x.setPrice(x.getPrice()+10000) ;
	});
		return setAllLap(l9);
}
}
