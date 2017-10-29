package com.epam.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Utility {
		
	public static String convertStreamToString(InputStreamReader isr){
		String output = "";
		BufferedReader br = new BufferedReader(isr);
		try {
			while ((output = br.readLine()) != null) {
				return output;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;
	}
	public static HttpURLConnection createGetRequest(String requestUrl){
		String userAgent =  "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
		URL url;
		try {
			url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent", userAgent);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
			 
	}

}
