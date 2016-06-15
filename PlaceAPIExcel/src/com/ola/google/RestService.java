package com.ola.google;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.SliderUI;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestService {
	
	public static Map<String, String> getFormattedAddressPlace (List<String> placeIdList) throws RestClientException {
		Map<String, String> responseList = new HashMap<String, String>();
		for (String placeId : placeIdList) {
			System.out.println("..." + placeId);
			RestTemplate restTemplate = new RestTemplate();
			HashMap<Object, Object> response = restTemplate.getForObject("https://maps.googleapis.com/maps/api/place/details/json?key=AIzaSyAuvk4J6aJX3Ch4iG7HUTSm2rqiEcFg8Oc&placeid=" + placeId, HashMap.class);
			HashMap<Object, Object> result = (HashMap<Object, Object>) response.get("result");
			String formttedAddress = (String) result.get("formatted_address");
			HashMap<Object, Object> geometry = (HashMap<Object, Object>) result.get("geometry");
			HashMap<Object, Object> location = (HashMap<Object, Object>) geometry.get("location");
			String lat = (String) location.get("lat").toString();
			String lng = (String) location.get("lng").toString();
			System.out.println("Fa.." + formttedAddress + "..." + lat + ", "  +  lng);
			responseList.put(placeId, formttedAddress + "###" + lat + ", "  +  lng);
		}
		return responseList;
	}
	
	public static Map<String, String> getFormattedAddressGeocode (List<String> placeIdList) throws RestClientException {
		Map<String, String> responseList = new HashMap<String, String>();
		for (String placeId : placeIdList) {
			RestTemplate restTemplate = new RestTemplate();
			HashMap<Object, Object> response = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAuvk4J6aJX3Ch4iG7HUTSm2rqiEcFg8Oc&place_id=" + placeId, HashMap.class);
			List <Object> results =  (List<Object>) response.get("results");
			HashMap<Object, Object> result = (HashMap<Object, Object>) results.get(0);
			String formttedAddress = (String) result.get("formatted_address");
			HashMap<Object, Object> geometry = (HashMap<Object, Object>) result.get("geometry");
			HashMap<Object, Object> location = (HashMap<Object, Object>) geometry.get("location");
			String lat = (String) location.get("lat").toString();
			String lng = (String) location.get("lng").toString();
			System.out.println("Fa.." + formttedAddress + "..." + lat + ", "  +  lng);
			responseList.put(placeId, formttedAddress + "###" + lat + ", "  +  lng);
		}
		return responseList;
	}
	
}
