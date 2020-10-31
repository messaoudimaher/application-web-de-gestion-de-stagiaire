package doc.entities;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Entity

public class Demande {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique = true)
        @Lob
        private byte[] cv;
        private String email;
        private String firstname;
        private String lastname;
        private Date dateDebut;
        private String etablissement;
        private String niveau;
        private String tel;
        private String specialite;
        private String themeDeRecherche;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }



        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
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

        public Demande() {
        }

        public byte[] getCv() {
                return cv;
        }

        public void setCv(byte[] cv) {
                this.cv = cv;
        }

        public Demande(Long id, byte[] cv, String email, String firstname, String lastname, Date dateDebut, String etablissement, String niveau, String tel, String specialite, String themeDeRecherche) {
                this.id = id;
                this.cv = cv;
                this.email = email;
                this.firstname = firstname;
                this.lastname = lastname;
                this.dateDebut = dateDebut;
                this.etablissement = etablissement;
                this.niveau = niveau;
                this.tel = tel;
                this.specialite = specialite;
                this.themeDeRecherche = themeDeRecherche;
        }
}
