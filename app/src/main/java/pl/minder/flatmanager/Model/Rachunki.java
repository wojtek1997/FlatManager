
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rachunki {

    @SerializedName("idRachunku")
    @Expose
    private Integer idRachunku;
    @SerializedName("opis")
    @Expose
    private String opis;
    @SerializedName("kwota")
    @Expose
    private Double kwota;
    @SerializedName("czyRozlicznoy")
    @Expose
    private Boolean czyRozlicznoy;

    public Integer getIdRachunku() {
        return idRachunku;
    }

    public void setIdRachunku(Integer idRachunku) {
        this.idRachunku = idRachunku;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public Boolean getCzyRozlicznoy() {
        return czyRozlicznoy;
    }

    public void setCzyRozlicznoy(Boolean czyRozlicznoy) {
        this.czyRozlicznoy = czyRozlicznoy;
    }

}
