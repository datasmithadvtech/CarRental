package com.carrental.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Equipment")
@JsonIgnoreProperties(value = { "equipmentList" })
public class Equipment implements Serializable {

	@Id
	@Column(name = "equipmentCode")
	@Size(max = 3)
	private String equipmentCode;

	@Column(name = "description")
	private String description;

	@ManyToMany(mappedBy="equipmentList")
	private List<Vehicle> carList = new ArrayList<Vehicle>();

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentCode=" + equipmentCode + ", description=" + description + "]";
	}

}