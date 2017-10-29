package com.epam.rest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PlanetTest {
	final static String GETALL_URL="https://swapi.co/api/planets/";
	final static String GETBYID_URL="http://swapi.co/api/planets/";
  @Test
  public void testStatusForALLPlanets() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL);
	  int statusCode = conn.getResponseCode();
	  assertEquals(200, statusCode);
  }
  @Test
  public void testStatusForPlanetWithId() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL+2);
	  int statusCode = conn.getResponseCode();
	  assertEquals(200, statusCode);
	  
  }
  @Test
  public void testPlanetCount() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL);
	  String output = Utility.convertStreamToString(new InputStreamReader(conn.getInputStream()));
	  JSONObject result = new JSONObject(output);
	  int count = result.optInt("count");
	  assertEquals(61, count);
  }
  @Test
	public void testPlanetNext() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL);
	  String output = Utility.convertStreamToString(new InputStreamReader(conn.getInputStream()));
	  JSONObject result = new JSONObject(output);
	  String next = result.optString("next");
	  assertEquals(next, "https://swapi.co/api/planets/?page=2"); 
  }
  @Test
	public void testPlanetString() throws Exception {
	  String str="{\"name\":\"Alderaan\",\"rotation_period\":\"24\",\"orbital_period\":\"364\",\"diameter\":\"12500\",\"climate\":\"temperate\",\"gravity\":\"1 standard\",\"terrain\":\"grasslands, mountains\",\"surface_water\":\"40\",\"population\":\"2000000000\",\"residents\":[\"https://swapi.co/api/people/5/\",\"https://swapi.co/api/people/68/\",\"https://swapi.co/api/people/81/\"],\"films\":[\"https://swapi.co/api/films/6/\",\"https://swapi.co/api/films/1/\"],\"created\":\"2014-12-10T11:35:48.479000Z\",\"edited\":\"2014-12-20T20:58:18.420000Z\",\"url\":\"https://swapi.co/api/planets/2/\"}";
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL+2);
	  String output = Utility.convertStreamToString(new InputStreamReader(conn.getInputStream()));
	  assertEquals(str, output); 
}
  @Test
	public void testPlanetURL() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL+1);
	  String output = Utility.convertStreamToString(new InputStreamReader(conn.getInputStream()));
	  JSONObject result = new JSONObject(output);
	  String url = result.optString("url");
	  assertEquals(url, "https://swapi.co/api/planets/1/"); 
}
  @Test
	public void testPlanetNotFound() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL);
	  String output = Utility.convertStreamToString(new InputStreamReader(conn.getInputStream()));
	  JSONObject result = new JSONObject(output);
	  int count = result.optInt("count");
	  conn = Utility.createGetRequest(GETALL_URL+count+1);
	  int statusCode = conn.getResponseCode();
	  assertEquals(404, statusCode);
	  
  }
  @Test
  public void testPlanetWrongCount() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL);
	  String output = Utility.convertStreamToString(new InputStreamReader(conn.getInputStream()));
	  JSONObject result = new JSONObject(output);
	  int count = result.optInt("count");
	  assertFalse(50==count);
  }
  @Test
  public void testPlanetSecondName() throws Exception {
	  HttpURLConnection conn = Utility.createGetRequest(GETALL_URL);
	  String output = Utility.convertStreamToString(new InputStreamReader(conn.getInputStream()));
	  JSONObject obj = new JSONObject(output);
	  JSONArray arr = obj.getJSONArray("results");
	  JSONObject secondItem = arr.getJSONObject(1);
	  String name = secondItem.optString("name");
	  int rotation_period= secondItem.optInt("rotation_period");
	  int orbital_period= secondItem.optInt("orbital_period");
	  int diameter= secondItem.optInt("diameter");
	  String climate=secondItem.optString("climate"); 
	  String gravity = secondItem.optString("gravity"); 
	  String terrain = secondItem.optString("terrain");
	  int surface_water = secondItem.optInt("surface_water");
	  int population = secondItem.optInt("population");
	  JSONArray residentArr = secondItem.getJSONArray("residents");
	  ArrayList<String> residents = new ArrayList<String>();
	  for(int i=0;i<residentArr.length();i++){
		  residents.add(residentArr.get(i).toString());
	  }
	  JSONArray filmArr = secondItem.getJSONArray("films");
	  ArrayList<String> films = new ArrayList<String>();
	  for(int i=0;i<filmArr.length();i++){
		  films.add(filmArr.get(i).toString());
	  }
	  String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";
	  SimpleDateFormat format = new SimpleDateFormat(pattern);
	  format.setTimeZone(TimeZone.getTimeZone("GMT"));
	  
	  Date created = format.parse(secondItem.optString("created"));
	  Date edited = format.parse(secondItem.optString("edited"));
      String url = secondItem.optString("url");
      
      Planet secondPlanet = new Planet(name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population, residents, films, created, edited, url);
      assertEquals("Yavin IV", secondPlanet.getName());
	  
  }
 
}
