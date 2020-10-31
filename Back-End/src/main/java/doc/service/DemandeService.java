package doc.service;

import doc.entities.Annonce;
import doc.exception.FileStorageException;
import doc.exception.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import doc.dao.DemandeRepository;
import doc.entities.Demande;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    public Demande storeFile(MultipartFile cv ,
                             String firstname,
                             String lastname,
                             String email,
                             Date dateDebut,
                             String etablissement,
                             String niveau,
                             String tel,
                             String specialite,
                             String themeDeRecherche) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(cv.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            //Demande(Long id, byte[] cv, String email, String firstname, String lastname, Date dateDebut, String etablissement, String niveau, String tel, String specialite, String themeDeRecherche)
            Demande demande = new Demande();
            demande.setEmail(email);
            demande.setFirstname(firstname);
            demande.setLastname(lastname);
            demande.setCv(cv.getBytes());
            demande.setDateDebut(dateDebut);
            demande.setEtablissement(etablissement);
            demande.setNiveau(niveau);
            demande.setTel(tel);
            demande.setSpecialite(specialite);
            demande.setThemeDeRecherche(themeDeRecherche);

            return demandeRepository.save(demande);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    public List<Demande> getAllDemandes() {

        return demandeRepository.findAll();
    }

    public Demande getDemande(long demandeId) {
        return demandeRepository.findById(demandeId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + demandeId));
    }
}