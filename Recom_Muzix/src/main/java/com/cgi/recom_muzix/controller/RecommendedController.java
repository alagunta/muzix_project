package com.cgi.recom_muzix.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.recom_muzix.model.Recommended;
import com.cgi.recom_muzix.repository.RecommendedRepository;
import com.cgi.recom_muzix.service.RecommendedService;
import com.muzix.recom_muzix.exception.RecommendationListEmpty;
import com.muzix.recom_muzix.exception.SongNameDoesnotExists;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/favMuzix")
public class RecommendedController {

	


	@Autowired
	private RecommendedService rsd;


	

	
	@GetMapping("/getAllRecom")
	public ResponseEntity<?> recommendAll() {
		ResponseEntity<?> rs = null;
		try {
			List<Recommended> blist = rsd.findALL();
			rs = ResponseEntity.status(HttpStatus.OK).body(blist);
		} catch (RecommendationListEmpty e) {
			rs = ResponseEntity.status(HttpStatus.CONFLICT).build();

		}
		return rs;
	}



	

	@PostMapping("/addRecom")
	public ResponseEntity<?> saveRecommendedcount(@RequestBody Recommended mf) throws SongNameDoesnotExists {
		ResponseEntity<?> rs = null;
		try {
			Recommended bk = rsd.saveRecom(mf);
			if (bk != null)
				rs = ResponseEntity.status(HttpStatus.CREATED).build();
			else
				rs = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		} catch (SongNameDoesnotExists e) {
			rs = ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;

	}

	

	/*@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteRecommended(@PathVariable Integer id){
		try 
		{
			Optional<Recommended> recommended = recommendedrepository.findById(id);
			
			if (recommended.isPresent()) 
			{
				recommendedservice.delete(recommended.get());
			}
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	
	

}
