package com.kch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kch.domain.Route;
import com.kch.repository.RouteRepository;

@Service("routeService")
@Transactional
public class RouteService {
 
    
    private RouteRepository routeRepository;
    @Autowired
    RouteService(RouteRepository routeRepository) {
    	this.routeRepository = routeRepository;
    }
    
    public Route findById(Long id) {
        return routeRepository.findOne(id);
    }
 
    public Route findByName(String name) {
        return routeRepository.findByName(name);
    }
 
    public void saveRoute(Route route) {
        routeRepository.save(route);
    }
 
    public void updateRoute(Route route){
        saveRoute(route);
    }
 
    public void deleteRouteById(Long id){
        routeRepository.delete(id);
    }
 
    public void deleteAllRoutes(){
        routeRepository.deleteAll();
    }
 
    public List<Route> findAllRoutes(){
        return (List<Route>) routeRepository.findAll();
    }
 
    public boolean isRouteExist(Route route) {
        return findByName(route.getName()) != null;
    }

}
