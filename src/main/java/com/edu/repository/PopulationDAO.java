package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.domain.Population;

public interface PopulationDAO extends JpaRepository<Population, Integer>{

}
