
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UzytkownicyUmowy {

    @SerializedName("idUzytkownicyUmowy")
    @Expose
    private Integer idUzytkownicyUmowy;
    @SerializedName("umowa")
    @Expose
    private Umowa umowa;
    @SerializedName("uzytkownik")
    @Expose
    private User uzytkownik;

    public Integer getIdUzytkownicyUmowy() {
        return idUzytkownicyUmowy;
    }

    public void setIdUzytkownicyUmowy(Integer idUzytkownicyUmowy) {
        this.idUzytkownicyUmowy = idUzytkownicyUmowy;
    }

    public Umowa getUmowa() {
        return umowa;
    }

    public void setUmowa(Umowa umowa) {
        this.umowa = umowa;
    }

    public User getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(User uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

}
