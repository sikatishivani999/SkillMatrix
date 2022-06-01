package com.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	
}
