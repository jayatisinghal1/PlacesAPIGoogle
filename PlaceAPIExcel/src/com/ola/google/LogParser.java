package com.ola.google;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogParser {
	
	public static List<String> getPlaceIds() throws FileNotFoundException, IOException{
		List<String> placeIds = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/jayati.singhal/Downloads/test/250/xad"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if(line.contains("/api/v1/places/search/placeApi?placeId=")){
		    	   placeIds.add(line.substring(line.indexOf("placeId=") + 8, line.indexOf("&")));
		       	   System.out.println(line.substring(line.indexOf("placeId=") + 8, line.indexOf("&")));
		       }   
		    }
		}
		return placeIds;
	}

}
