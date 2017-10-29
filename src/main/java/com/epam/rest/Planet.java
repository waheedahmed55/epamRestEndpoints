package com.epam.rest;

import java.util.ArrayList;
import java.util.Date;

public class Planet {
	private String name;
    private int rotation_period;
    private int orbital_period;
    private int diameter;
    private String climate; 
    private String gravity; 
    private String terrain;
    private int surface_water;
    private int population;
    private ArrayList<String> residents;
    private ArrayList<String> films;
    private Date created;
    private Date edited;
    private String url;
    
    
    //constructor
	public Planet(String name, int rotation_period, int orbital_period, int diameter, String climate, String gravity,
			String terrain, int surface_water, int population, ArrayList<String> residents, ArrayList<String> films,
			Date created, Date edited, String url) {
		super();
		this.name = name;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.population = population;
		this.residents = residents;
		this.films = films;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRotation_period() {
		return rotation_period;
	}
	public void setRotation_period(int rotation_period) {
		this.rotation_period = rotation_period;
	}
	public int getOrbital_period() {
		return orbital_period;
	}
	public void setOrbital_period(int orbital_period) {
		this.orbital_period = orbital_period;
	}
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getGravity() {
		return gravity;
	}
	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public int getSurface_water() {
		return surface_water;
	}
	public void setSurface_water(int surface_water) {
		this.surface_water = surface_water;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public ArrayList<String> getResidents() {
		return residents;
	}
	public void setResidents(ArrayList<String> residents) {
		this.residents = residents;
	}
	public ArrayList<String> getFilms() {
		return films;
	}
	public void setFlims(ArrayList<String> films) {
		this.films = films;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getEdited() {
		return edited;
	}
	public void setEdited(Date edited) {
		this.edited = edited;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
    

}
