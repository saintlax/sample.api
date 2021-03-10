package com.atbtechsoft.sample.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.atbtechsoft.sample.models.QueryData;

@Component
public class Utilities {

	public String RANGE = "RANGE";
	public String NOT = "NOT";
	public String OR = "OR";
	public String IN = "IN";
	
	public QueryData sortPayload(String payload) {
		QueryData queryData = new QueryData();
		queryData.setPage(1);
		queryData.setPopulation(100);
		String[] data = payload.split("&");
    	List<String> query = new ArrayList<>();
    	int count = 0;
    	for(String input: data) {			
    		String[] node = input.split("=");
    		if(node.length > 0) {
				if(count == 0) {					
					if(node[1].contains("~")) {
						String[] Data = node[1].split("~");
						if(Data.length > 0) {
							queryData.setType(RANGE);
							for(String d : Data) {
								query.add(d);
							}
							queryData.setData(query);
						}
					}
					
					if(node[1].contains(",")) {
						String[] Data = node[1].split(",");
						if(Data.length > 0) {
							queryData.setType(OR);
							for(String d : Data) {
								query.add(d);
							}
							queryData.setData(query);
						}
					}
					
					if(node[1].contains("!")) {
						String[] Data = node[1].split("!");
						if(Data.length > 0) {
							queryData.setType(NOT);
							for(String d : Data) {
								query.add(d);
							}
							queryData.setData(query);
						}
					}
					
					if(node[1].contains(":")) {
						String[] Data = node[1].split(":");
						if(Data.length > 0) {
							queryData.setType(IN);
							for(String d : Data) {
								query.add(d);
							}
							queryData.setData(query);
						}
					}
					
				}
				
				if(node[0].equalsIgnoreCase("count")) {
					queryData.setCount(Long.parseLong(node[1]));
				}
				if(node[0].equalsIgnoreCase("page")) {
					queryData.setPage(Integer.parseInt(node[1]));
				}
				if(node[0].equalsIgnoreCase("population")) {
					queryData.setPopulation(Integer.parseInt(node[1]));
				}
				if(node[0].equalsIgnoreCase("return_only")) {
					queryData.setReturn_only(node[1]);
				}
				if(node[0].equalsIgnoreCase("sort_by")) {
					queryData.setSort_by(node[1]);
				}
    			
				count++;
    		}
    		
    	}
		return queryData;
	}
    
	
	public boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
}
