package com.bridgelabz.hibcriteriaApp.Dto;

import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "mobileTable")
public class MobileDto implements Serializable 
{
public MobileDto() 
{
	
}
	@Id
	@GenericGenerator(name = "mid", strategy = "increment")
	@GeneratedValue(generator = "mid")
	@Column(name = "m_id")
	private int id;
	@Column(name = "m_brand")
	private String brand;
	@Column(name = "m_color")
	private String color;
	@Column(name = "m_price")
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
