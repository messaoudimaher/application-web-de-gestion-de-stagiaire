package doc.web;

import doc.dao.DemandeRepository;
import doc.entities.Annonce;
import doc.entities.Demande;
import doc.entities.User;
import doc.service.DemandeService;
import lombok.Data;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DemandeController {

    private static final Logger logger = LoggerFactory.getLogger(DemandeController.class);

    @Autowired
    private DemandeService demandeService;

    @Autowired
    private DemandeRepository demandeRepository;

    @PostMapping("/postuler-demande")
    //@RequestMapping(value ="/postuler-demande", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public DemandeForm uploadFile(@ModelAttribute DemandeForm demande) {
        Demande dbFile = demandeService.storeFile(demande.getCv(),demande.getFirstname(), demande.getLastname(), demande.getEmail(), demande.getDateDebut(),demande.getEtablissement(),demande.getNiveau(), demande.getTel(), demande.getSpecialite(), demande.getThemeDeRecherche());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(String.valueOf(dbFile.getId()))
                .toUriString();

        return new DemandeForm(demande.getFirstname(), demande.getLastname(), demande.getEmail(), demande.getDateDebut(),demande.getEtablissement(),demande.getNiveau(), demande.getTel(), demande.getSpecialite(), demande.getThemeDeRecherche(),demande.getCv());
    }

    @DeleteMapping("/delete_demande/{id}")
    public Map<String, Boolean> deleteStagiaire(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found for this id :: " + id));

        demandeRepository.delete(demande);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/list-demandes")
    public List<Demande> getAll()
    {
        return demandeService.getAllDemandes();
    }

}
@Data
class DemandeForm{

    private String firstname;
    private String lastname;
    private String email;
    private Date dateDebut;
    private String etablissement;
    private String niveau;
    private String tel;
    private String specialite;
    private String themeDeRecherche;
    private MultipartFile cv;

    public DemandeForm(String firstname, String lastname, String email, Date dateDebut, String etablissement, String niveau, String tel, String specialite, String themeDeRecherche, MultipartFile cv) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateDebut = dateDebut;
        this.etablissement = etablissement;
        this.niveau = niveau;
        this.tel = tel;
        this.specialite = specialite;
        this.themeDeRecherche = themeDeRecherche;
        this.cv = cv;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getThemeDeRecherche() {
        return themeDeRecherche;
    }

    public void setThemeDeRecherche(String themeDeRecherche) {
        this.themeDeRecherche = themeDeRecherche;
    }

    public MultipartFile getCv() {
        return cv;
    }

    public void setCv(MultipartFile cv) {
        this.cv = cv;
    }


}
