package com.kch.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_history")
public class DataHistory {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "data_from", nullable = false)
	private String dataFrom;
	
	@Column(name = "data_to", nullable = false)
	private String dataTo;
	
	public Long getId() {
	  return id;
	 }

	 public void setId(Long id) {
	  this.id = id;
	 }

	 public String getDataFrom() {
	  return dataFrom;
	 }

	 public void setFirstName(String dataFrom) {
	  this.dataFrom = dataFrom;
	 }

	 public String getDataTo() {
	  return dataTo;
	 }

	 public void setLastName(String dataTo) {
	  this.dataTo = dataTo;
	 }
}

