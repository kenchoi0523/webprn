package com.kch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kch.domain.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

	Route findByName(String name);
}
