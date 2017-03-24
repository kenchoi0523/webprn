package com.kch.controller;

import java.util.List;

import com.kch.domain.DataHistory;
import com.kch.domain.Route;
import com.kch.service.RouteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RestRouteController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestRouteController.class);
	
	RouteService routeService; 
    
	@Autowired
	RestRouteController(RouteService routeService) {
		this.routeService = routeService;
	}
    
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<?> listSomeRoutes() {
        List<Route> routes = routeService.findAllRoutes();
        if (routes.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Route>>(routes, HttpStatus.OK);
    }
	
    // -------------------Retrieve All Routes---------------------------------------------
 
    @RequestMapping(value = "/route/", method = RequestMethod.GET)
    public ResponseEntity<List<Route>> listAllRoutes() {
        List<Route> routes = routeService.findAllRoutes();
        if (routes.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Route>>(routes, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Route------------------------------------------
 
    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRoute(@PathVariable("id") long id) {
        logger.info("Fetching Route with id {}", id);
        Route route = routeService.findById(id);
        if (route == null) {
            logger.error("Route with id {} not found.", id);
            return new ResponseEntity(new Exception("Route with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Route>(route, HttpStatus.OK);
    }
 
    // -------------------Create a Route-------------------------------------------
 
    @RequestMapping(value = "/route/", method = RequestMethod.POST)
    public ResponseEntity<?> createRoute(@RequestBody Route route, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Route : {}", route);
 
        if (routeService.isRouteExist(route)) {
            logger.error("Unable to create. A Route with name {} already exist", route.getName());
            return new ResponseEntity(new Exception("Unable to create. A Route with name " + 
            route.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        routeService.saveRoute(route);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/route/{id}").buildAndExpand(route.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Route ------------------------------------------------
 
    @RequestMapping(value = "/route/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRoute(@PathVariable("id") long id, @RequestBody Route route) {
        logger.info("Updating Route with id {}", id);
 
        Route currentRoute = routeService.findById(id);
 
        if (currentRoute == null) {
            logger.error("Unable to update. Route with id {} not found.", id);
            return new ResponseEntity(new Exception("Unable to upate. Route with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentRoute.setName(route.getName());
        currentRoute.setRouteFrom(route.getRouteFrom());
        currentRoute.setRouteTo(route.getRouteTo());
        currentRoute.setInputFormat(route.getInputFormat());
        currentRoute.setOutputFormat(route.getOutputFormat());
        currentRoute.setTransferMethod(route.getTransferMethod());
 
        routeService.updateRoute(currentRoute);
        return new ResponseEntity<Route>(currentRoute, HttpStatus.OK);
    }
 
    // ------------------- Delete a Route-----------------------------------------
 
    @RequestMapping(value = "/route/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRoute(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Route with id {}", id);
 
        Route route = routeService.findById(id);
        if (route == null) {
            logger.error("Unable to delete. Route with id {} not found.", id);
            return new ResponseEntity(new Exception("Unable to delete. Route with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        routeService.deleteRouteById(id);
        return new ResponseEntity<Route>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Routes-----------------------------
 
    @RequestMapping(value = "/route/", method = RequestMethod.DELETE)
    public ResponseEntity<Route> deleteAllRoutes() {
        logger.info("Deleting All Routes");
 
        routeService.deleteAllRoutes();
        return new ResponseEntity<Route>(HttpStatus.NO_CONTENT);
    }
}
