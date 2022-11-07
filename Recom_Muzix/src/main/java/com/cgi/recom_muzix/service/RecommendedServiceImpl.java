package com.cgi.recom_muzix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.recom_muzix.model.Recommended;
import com.cgi.recom_muzix.repository.RecommendedRepository;
import com.muzix.recom_muzix.exception.RecommendationListEmpty;
import com.muzix.recom_muzix.exception.SongNameDoesnotExists;


@Service
public class RecommendedServiceImpl implements RecommendedService {
	@Autowired
	private RecommendedRepository rf;

	@Override
	public List<Recommended> findALL() throws RecommendationListEmpty {
		List<Recommended> culist = rf.findAll();
		if (culist.isEmpty())
			throw new RecommendationListEmpty();
		return culist;
	}

	@Override
	public Recommended saveRecom(Recommended mf) throws SongNameDoesnotExists {
		System.out.println("Inside recommendation");
		Optional<Recommended> o = rf.findById(mf.getArtistSongName());
		Recommended rm = new Recommended();
		if (o.isPresent()) {
			Recommended r = o.get();
			rm.setArtistSongName(r.getArtistSongName());
			rm.setRecommendationCount(r.getRecommendationCount() + 1);
			rm.setAlbumSingle(r.getAlbumSingle());
			rm.setArtist_name(r.getArtist_name());
			rm.setImage(r.getImage());
			rm.setTrackSingle(r.getTrackSingle());

		} else {
			rm.setArtistSongName(mf.getArtistSongName());
			rm.setRecommendationCount(1);
			rm.setAlbumSingle(mf.getAlbumSingle());
			rm.setArtist_name(mf.getArtist_name());
			rm.setImage(mf.getImage());
			rm.setTrackSingle(mf.getTrackSingle());
		}
		System.out.println("Showing object");
		System.out.println(rm.toString());
		Recommended rs = rf.save(rm);
		return rs;
	}

}
