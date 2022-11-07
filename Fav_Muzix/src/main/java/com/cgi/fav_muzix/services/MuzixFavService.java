package com.cgi.fav_muzix.services;

import java.util.List;

import com.cgi.fav_muzix.exception.MuzixAlreadyExistsException;
import com.cgi.fav_muzix.exception.MuzixFavListEmpty;
import com.cgi.fav_muzix.model.MuzixFav;


public interface MuzixFavService {
	public List<MuzixFav> findALL() throws MuzixFavListEmpty;

	public MuzixFav getFavMusicById(String id) throws MuzixAlreadyExistsException;

	public MuzixFav saveFav(MuzixFav mf) throws MuzixAlreadyExistsException;

	
}
