package com.atbtechsoft.sample.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atbtechsoft.sample.models.Payload;
import com.atbtechsoft.sample.models.Response;
import com.atbtechsoft.sample.services.Implementation;

@CrossOrigin(origins = "*")
@RestController("SampleRestController")
public class Sample {
	
	@Autowired
	Implementation implementationService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addPayload(@RequestBody Payload payload){
		try {
			Response response = implementationService.addPayload(payload);
			if(response != null) {
				if(response.getError().equalsIgnoreCase("") && response.getPayload() != null) {
					return new ResponseEntity<>(response, HttpStatus.OK);
				}
			}			
			return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
		} catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
	}
			
	@RequestMapping(value = "/{query}", method = RequestMethod.GET)	
    public ResponseEntity<?> getAllPayload(@PathVariable String query){		
		try {
			return new ResponseEntity<>(implementationService.get(query), HttpStatus.OK);
		} catch (Exception e) {
            e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@RequestMapping(value = "/search/{key}/{keyword}", method = RequestMethod.GET)	
    public ResponseEntity<?> search(@PathVariable String key, @PathVariable String keyword){		
		try {
			return new ResponseEntity<>(implementationService.findBySearch(key,keyword), HttpStatus.OK);
		} catch (Exception e) {
            e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	
	@RequestMapping(value = "/{data}", method = RequestMethod.DELETE)	
    public ResponseEntity<?> deleteClientProfile(@PathVariable String data){
		
		try {
			return new ResponseEntity<>(implementationService.delete(data), HttpStatus.OK);
		} catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
	}
	
	
}
