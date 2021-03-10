package com.atbtechsoft.sample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atbtechsoft.sample.models.Payload;
import com.atbtechsoft.sample.models.QueryData;
import com.atbtechsoft.sample.models.Response;
import com.atbtechsoft.sample.utils.Utilities;

@Service("ImplementationService")
public class Implementation {
	@Autowired
	Utilities utilities;
	List<Payload> data = new ArrayList<>();
	
	
	public Response addPayload(Payload payload) {
		Response response = new Response();
		//db action
		data.add(payload);
		response.setError("");
		response.setPayload(payload);
		response.setStatusCode(200);
		return response;		
	}
	
	public Response findById(int id) {
		Response response = new Response();
		Payload payload = data.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);	
		response.setPayload(payload);
		response.setError("SUCCESS");
		response.setStatusCode(200);
		return response;		
	}
	
	public Response findByNameIN(List<String> names) {
		Response response = new Response();
		response.setError("ERROR");
		response.setStatusCode(501);
		List<Payload> payloads = new ArrayList<>();
		for(String name : names) {
			Payload payload = data.stream().filter(a -> a.getName() == name).collect(Collectors.toList()).get(0);
			payloads.add(payload);
			response.setError("");
			response.setStatusCode(200);
		}
		response.setPayload(payloads);		
		return response;		
	}
	public Response findBySearch(String key,String keyword) {
		Response response = new Response();
		response.setError("ERROR");
		response.setStatusCode(501);
		List<Payload> payloads = data.stream().filter(a -> (a.getName() == keyword || a.getName() == key)).collect(Collectors.toList());
		response.setError("");
		response.setStatusCode(200);
		response.setPayload(payloads);		
		return response;		
	}
	
	public Response getAllPayload() {
		Response response = new Response();
		response.setPayload(data);
		response.setError("SUCCESS");
		response.setStatusCode(200);
		return response;		
	}
	
	public Response get(String query) {
		try {
			if(utilities.isNumeric(query)) {
				return findById(Integer.parseInt(query));
			}else {
				QueryData queryData = utilities.sortPayload(query);
				if(queryData != null) {
					if(queryData.getType() == utilities.RANGE) {
						System.out.println("Filter DB BY RANGE");
					}
					if(queryData.getType() == utilities.NOT) {
						System.out.println("Filter DB BY NOT");
					}
					if(queryData.getType() == utilities.IN) {
						System.out.println("Filter DB BY IN");
						return findByNameIN(queryData.getData());
					}
					if(queryData.getType() == utilities.OR) {
						System.out.println("Filter DB BY OR");
					}
				}
				return 	getAllPayload();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Response();
		}		
	}
	
	
	
	
}
