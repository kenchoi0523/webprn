package com.kch.controller;

import java.util.ArrayList;
import java.util.List;


import com.kch.domain.DataHistory;
import com.kch.repository.DataHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDataHistoryController {
	
	DataHistoryRepository repo;
	List<DataHistory> dataHist = new ArrayList<DataHistory>();
    
	
	@Autowired
	RestDataHistoryController(DataHistoryRepository dataHistoryRepository) {
		this.repo = dataHistoryRepository;
	}
	
		
	
    @RequestMapping(value = "/getalldatahistory", method = RequestMethod.GET)
    public List<DataHistory> getResource(){
    	System.out.println("dataHist : " + dataHist.size());
    	dataHist.clear();
    	repo.findAll().forEach(dataHist::add);
        return dataHist;
    }
     
    
    
    @RequestMapping(value="/postdatahistory", method=RequestMethod.POST)
    public void postCustomer(@RequestBody DataHistory dataHistory){
    	System.out.println("dataHistory : " + dataHistory.toString());
    	dataHist.add(dataHistory);
    	repo.save(dataHistory);
        return;
    }
}
