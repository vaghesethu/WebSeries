package com.webseries.webapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webseries.webapp.bean.SeriesModel;

public interface SeriesRepo extends JpaRepository<SeriesModel, Integer> {

	Optional<SeriesModel> findByName(String name);
}
