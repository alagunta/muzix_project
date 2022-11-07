package com.cgi.fav_muzix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.fav_muzix.exception.MuzixAlreadyExistsException;
import com.cgi.fav_muzix.exception.MuzixFavListEmpty;
import com.cgi.fav_muzix.model.MuzixFav;
import com.cgi.fav_muzix.repository.MuzixFavRepository;


@Service
public class MuzixFavServiceImpl implements MuzixFavService {

	@Autowired
	private MuzixFavRepository bp;

	@Override
	public List<MuzixFav> findALL() throws MuzixFavListEmpty {
		List<MuzixFav> culist = bp.findAll();
		if (culist.isEmpty())
			throw new MuzixFavListEmpty();
		return culist;
	}

	@Override
	public MuzixFav getFavMusicById(String id) throws MuzixAlreadyExistsException {
		Optional<MuzixFav> o = bp.findById(id);
		if (!o.isPresent())
			throw new MuzixAlreadyExistsException("Id doesnot exists!");
		// TODO Auto-generated method stub
		MuzixFav bk = o.get();
		System.out.println("Inside Service of MUSICFav app");
		return bk;
	}

	@Override
	public MuzixFav saveFav(MuzixFav mf) throws MuzixAlreadyExistsException {
		Optional<MuzixFav> o = bp.findById(mf.getArtistSongName());
		if (o.isPresent())
			throw new MuzixAlreadyExistsException("Entry already exists in the list");

		MuzixFav mk = bp.save(mf);

		return mk;
	}

}
