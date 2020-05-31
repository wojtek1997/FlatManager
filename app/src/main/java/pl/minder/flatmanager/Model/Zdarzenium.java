
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Zdarzenium {

    @SerializedName("idZdarzenia")
    @Expose
    private Integer idZdarzenia;
    @SerializedName("typZdarzenia")
    @Expose
    private String typZdarzenia;
    @SerializedName("opis")
    @Expose
    private String opis;
    @SerializedName("dataZgloszenia")
    @Expose
    private String dataZgloszenia;

    public Integer getIdZdarzenia() {
        return idZdarzenia;
    }

    public void setIdZdarzenia(Integer idZdarzenia) {
        this.idZdarzenia = idZdarzenia;
    }

    public String getTypZdarzenia() {
        return typZdarzenia;
    }

    public void setTypZdarzenia(String typZdarzenia) {
        this.typZdarzenia = typZdarzenia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDataZgloszenia() {
        return dataZgloszenia;
    }

    public void setDataZgloszenia(String dataZgloszenia) {
        this.dataZgloszenia = dataZgloszenia;
    }

}
