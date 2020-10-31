package doc.service;

import java.util.List;

import javax.transaction.Transactional;

import doc.dao.UserRepository;
import doc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doc.dao.AnnonceRepository;
import doc.entities.Annonce;
@Service
@Transactional
public class AnnonceService implements IAnnonceService{

	@Autowired
	AnnonceRepository annonceRepository;
	@Override
	public List<Annonce> getAllAnnonces() {
		
		return annonceRepository.findAll();
	}
	@Override
	public Annonce saveAnnonce(Annonce annonce) {
		
		return annonceRepository.save(annonce);
	}

	public void deleteAnnance (Long id){
		annonceRepository.deleteById(id);
	}




}
