
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Uzytkownicydsa {

    @SerializedName("idUzytkownika")
    @Expose
    private Integer idUzytkownika;
    @SerializedName("typUzytkownika")
    @Expose
    private String typUzytkownika;
    @SerializedName("imie")
    @Expose
    private String imie;
    @SerializedName("nazwisko")
    @Expose
    private String nazwisko;
    @SerializedName("nrTelefonu")
    @Expose
    private Integer nrTelefonu;
    @SerializedName("adresEmail")
    @Expose
    private String adresEmail;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("haslo")
    @Expose
    private String haslo;
    @SerializedName("uzytkownicy_umowy")
    @Expose
    private List<UzytkownicyUmowy> uzytkownicyUmowy = null;
    @SerializedName("uzytkownicy_mieszkania")
    @Expose
    private List<UzytkownicyMieszkanium> uzytkownicyMieszkania = null;
    @SerializedName("uzytkownicy_rachunki")
    @Expose
    private List<UzytkownicyRachunki> uzytkownicyRachunki = null;
    @SerializedName("uzytkownicy_zdarzenia")
    @Expose
    private List<UzytkownicyZdarzenium> uzytkownicyZdarzenia = null;

    public Integer getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Integer idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getTypUzytkownika() {
        return typUzytkownika;
    }

    public void setTypUzytkownika(String typUzytkownika) {
        this.typUzytkownika = typUzytkownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Integer getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(Integer nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public List<UzytkownicyUmowy> getUzytkownicyUmowy() {
        return uzytkownicyUmowy;
    }

    public void setUzytkownicyUmowy(List<UzytkownicyUmowy> uzytkownicyUmowy) {
        this.uzytkownicyUmowy = uzytkownicyUmowy;
    }

    public List<UzytkownicyMieszkanium> getUzytkownicyMieszkania() {
        return uzytkownicyMieszkania;
    }

    public void setUzytkownicyMieszkania(List<UzytkownicyMieszkanium> uzytkownicyMieszkania) {
        this.uzytkownicyMieszkania = uzytkownicyMieszkania;
    }

    public List<UzytkownicyRachunki> getUzytkownicyRachunki() {
        return uzytkownicyRachunki;
    }

    public void setUzytkownicyRachunki(List<UzytkownicyRachunki> uzytkownicyRachunki) {
        this.uzytkownicyRachunki = uzytkownicyRachunki;
    }

    public List<UzytkownicyZdarzenium> getUzytkownicyZdarzenia() {
        return uzytkownicyZdarzenia;
    }

    public void setUzytkownicyZdarzenia(List<UzytkownicyZdarzenium> uzytkownicyZdarzenia) {
        this.uzytkownicyZdarzenia = uzytkownicyZdarzenia;
    }

}
