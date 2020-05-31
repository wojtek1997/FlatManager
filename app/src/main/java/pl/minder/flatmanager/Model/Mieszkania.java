
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Mieszkania {

    @SerializedName("idMieszkania")
    @Expose
    private Integer idMieszkania;
    @SerializedName("miasto")
    @Expose
    private String miasto;
    @SerializedName("ulica")
    @Expose
    private String ulica;
    @SerializedName("nrDomu")
    @Expose
    private Integer nrDomu;
    @SerializedName("nrMieszkania")
    @Expose
    private Integer nrMieszkania;
    @SerializedName("powierzchnia")
    @Expose
    private Double powierzchnia;
    @SerializedName("liczbaPokoi")
    @Expose
    private Integer liczbaPokoi;
    @SerializedName("umowy")
    @Expose
    private List<Umowy> umowy = null;
    @SerializedName("rachunki")
    @Expose
    private List<Rachunki_> rachunki = null;
    @SerializedName("zdarzenia")
    @Expose
    private List<Zdarzenium_> zdarzenia = null;

    public Integer getIdMieszkania() {
        return idMieszkania;
    }

    public void setIdMieszkania(Integer idMieszkania) {
        this.idMieszkania = idMieszkania;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Integer getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(Integer nrDomu) {
        this.nrDomu = nrDomu;
    }

    public Integer getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(Integer nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public Double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public Integer getLiczbaPokoi() {
        return liczbaPokoi;
    }

    public void setLiczbaPokoi(Integer liczbaPokoi) {
        this.liczbaPokoi = liczbaPokoi;
    }

    public List<Umowy> getUmowy() {
        return umowy;
    }

    public void setUmowy(List<Umowy> umowy) {
        this.umowy = umowy;
    }

    public List<Rachunki_> getRachunki() {
        return rachunki;
    }

    public void setRachunki(List<Rachunki_> rachunki) {
        this.rachunki = rachunki;
    }

    public List<Zdarzenium_> getZdarzenia() {
        return zdarzenia;
    }

    public void setZdarzenia(List<Zdarzenium_> zdarzenia) {
        this.zdarzenia = zdarzenia;
    }

}
