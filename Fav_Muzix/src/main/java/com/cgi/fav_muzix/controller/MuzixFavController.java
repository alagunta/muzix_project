package com.cgi.fav_muzix.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.fav_muzix.exception.MuzixAlreadyExistsException;
import com.cgi.fav_muzix.exception.MuzixFavListEmpty;
import com.cgi.fav_muzix.model.MuzixFav;
import com.cgi.fav_muzix.services.MuzixFavService;





//@SuppressWarnings("unused")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/favMuzix")
public class MuzixFavController {

	

	@Autowired
	private MuzixFavService ms;

	

	

	@GetMapping("/getFav/{id}")
	public ResponseEntity<?> getFavMuzix(@PathVariable("id") String id) {
		System.out.println("Inside getFAV{id}");
		System.out.println(id);
		ResponseEntity<?> rs = null;
		try {
			MuzixFav b = ms.getFavMusicById(id);
			rs = ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (MuzixAlreadyExistsException e) {
			rs = ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		System.out.println(rs);
		return rs;
	}


	

	@PostMapping("/saveFav")
	public ResponseEntity<?> saveFavList(@RequestBody MuzixFav mf) {
		ResponseEntity<?> rs = null;
		try {
			MuzixFav bk = ms.saveFav(mf);
			if (bk != null)
				rs = ResponseEntity.status(HttpStatus.CREATED).build();
			else
				rs = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		} catch (MuzixAlreadyExistsException e) {
			rs = ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;

	}

	

	
	@GetMapping("/getallFav")
	public ResponseEntity<?> viewAll() {
		ResponseEntity<?> rs = null;
		try {
			List<MuzixFav> blist = ms.findALL();
			rs = ResponseEntity.status(HttpStatus.OK).body(blist);
		} catch (MuzixFavListEmpty e) {
			rs = ResponseEntity.status(HttpStatus.CONFLICT).build();

		}
		return rs;
	}

}
