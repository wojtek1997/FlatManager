
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MieszkaniaZ {

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
    private List<UmowyNew> umowy = null;
    @SerializedName("rachunki")
    @Expose
    private List<Rachunki__> rachunki = null;

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

    public List<UmowyNew> getUmowy() {
        return umowy;
    }

    public void setUmowy(List<UmowyNew> umowy) {
        this.umowy = umowy;
    }

    public List<Rachunki__> getRachunki() {
        return rachunki;
    }

    public void setRachunki(List<Rachunki__> rachunki) {
        this.rachunki = rachunki;
    }

}
