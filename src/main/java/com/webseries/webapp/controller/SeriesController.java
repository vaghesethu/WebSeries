package com.webseries.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webseries.webapp.bean.SeriesModel;
import com.webseries.webapp.dao.SeriesRepo;

@RestController
public class SeriesController {
	
	@Autowired
	SeriesRepo repo;
	
	@PostMapping("/addSeries")
	public SeriesModel save(SeriesModel series) {
		repo.save(series);
		return series;
	}
	@GetMapping("/series")
	public List<SeriesModel> getSeries() {
		return repo.findAll();
	}
	@GetMapping("/series/id/{id}")
	public Optional<SeriesModel> getSeriesById(@PathVariable("id") int id) {
		return repo.findById(id);
	}
	@GetMapping("/series/name/{name}")
	public Optional<SeriesModel> getSeriesByName(@PathVariable("name") String name) {
		return repo.findByName(name);
	}
	@PutMapping("/update")
	public SeriesModel update(SeriesModel series) {
		repo.save(series);
		return series;
	}
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Series Deleted!"+id;
		}
		return null;
	}
}
