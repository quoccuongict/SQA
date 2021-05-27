package com.insurrance.model;

import java.io.Serializable;

public class LevelPrice implements Serializable{

	private static final long serialVersionUID = -7059753463695774638L;

	private int id;
	private String typeLevel;
    private float price;
    private String description;
    
	public LevelPrice() {
		super();
	}

	public LevelPrice(int id, String typeLevel, float price, String description) {
		super();
		this.id = id;
		this.typeLevel = typeLevel;
		this.price = price;
		this.description = description;
	}

	public LevelPrice(String typeLevel, float price, String description) {
		super();
		this.typeLevel = typeLevel;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeLevel() {
		return typeLevel;
	}

	public void setTypeLevel(String typeLevel) {
		this.typeLevel = typeLevel;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	@Override
	public String toString() {
		return id + " " + typeLevel + " " + price + " " + description;
	}
}
