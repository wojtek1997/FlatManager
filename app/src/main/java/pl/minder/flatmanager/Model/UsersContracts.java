package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersContracts {

    @SerializedName("idUzytkownicyUmowy")
    @Expose
    private Long idUzytkownicyUmowy;
    @SerializedName("umowa")
    @Expose
    private Contract umowa;
    @SerializedName("uzytkownik")
    @Expose
    private User uzytkownik;

    public Long getIdUzytkownicyUmowy() {
        return idUzytkownicyUmowy;
    }

    public void setIdUzytkownicyUmowy(Long idUzytkownicyUmowy) {
        this.idUzytkownicyUmowy = idUzytkownicyUmowy;
    }

    public Contract getUmowa() {
        return umowa;
    }

    public void setUmowa(Contract umowa) {
        this.umowa = umowa;
    }

    public User getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(User uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
}
