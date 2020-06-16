package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flat {

    @SerializedName("idMieszkania")
    @Expose
    private Long idMieszkania;
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

    public Long getIdMieszkania() {
        return idMieszkania;
    }

    public void setIdMieszkania(Long idMieszkania) {
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
}
