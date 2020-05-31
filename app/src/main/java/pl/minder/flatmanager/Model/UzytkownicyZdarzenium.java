
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UzytkownicyZdarzenium {

    @SerializedName("idUzytkownicyZdarzenia")
    @Expose
    private Integer idUzytkownicyZdarzenia;
    @SerializedName("zdarzenie")
    @Expose
    private Zdarzenie zdarzenie;
    @SerializedName("uzytkownicyZ")
    @Expose
    private UzytkownicyZ uzytkownicyZ;

    public Integer getIdUzytkownicyZdarzenia() {
        return idUzytkownicyZdarzenia;
    }

    public void setIdUzytkownicyZdarzenia(Integer idUzytkownicyZdarzenia) {
        this.idUzytkownicyZdarzenia = idUzytkownicyZdarzenia;
    }

    public Zdarzenie getZdarzenie() {
        return zdarzenie;
    }

    public void setZdarzenie(Zdarzenie zdarzenie) {
        this.zdarzenie = zdarzenie;
    }

    public UzytkownicyZ getUzytkownicyZ() {
        return uzytkownicyZ;
    }

    public void setUzytkownicyZ(UzytkownicyZ uzytkownicyZ) {
        this.uzytkownicyZ = uzytkownicyZ;
    }

}
