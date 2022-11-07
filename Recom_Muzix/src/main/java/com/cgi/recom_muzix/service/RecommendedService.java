package com.cgi.recom_muzix.service;

import java.util.List;

import com.cgi.recom_muzix.model.Recommended;
import com.muzix.recom_muzix.exception.RecommendationListEmpty;
import com.muzix.recom_muzix.exception.SongNameDoesnotExists;


public interface RecommendedService {
	public List<Recommended> findALL() throws RecommendationListEmpty;

	public Recommended saveRecom(Recommended mf) throws SongNameDoesnotExists;

}
