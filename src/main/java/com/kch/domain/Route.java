package com.kch.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;
		
	@Column(name = "route_from", nullable = false)
	private String routeFrom;
	
	@Column(name = "route_to", nullable = false)
	private String routeTo;
	
	@Column(name = "input_format", nullable = false)
	private String inputFormat;
	
	@Column(name = "output_format", nullable = false)
	private String outputFormat;
	
	@Column(name = "transfer_method", nullable = false)
	private String transferMethod;
	
	public String getTransferMethod() {
		return transferMethod;
	}

	public void setTransferMethod(String transferMethod) {
		this.transferMethod = transferMethod;
	}

	public Long getId() {
	  return id;
	}

	 public void setId(Long id) {
	  this.id = id;
	 }

	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	 public String getRouteFrom() {
	  return routeFrom;
	 }

	 public void setRouteFrom(String routeFrom) {
	  this.routeFrom = routeFrom;
	 }

	 public String getRouteTo() {
	  return routeTo;
	 }

	 public void setRouteTo(String routeTo) {
	  this.routeTo = routeTo;
	 }
	 
	 public String getInputFormat() {
		return inputFormat;
	 }

	public void setInputFormat(String inputFormat) {
		this.inputFormat = inputFormat;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

		
}

