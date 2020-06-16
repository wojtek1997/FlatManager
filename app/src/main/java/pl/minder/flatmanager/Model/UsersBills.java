package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersBills {

    @SerializedName("idUzytkownicyRachunki")
    @Expose
    private Long idUzytkownicyRachunki;
    @SerializedName("rachunek")
    @Expose
    private Bill rachunek;
    @SerializedName("uzytkownicyR")
    @Expose
    private User uzytkownicyR;

    public Long getIdUzytkownicyRachunki() {
        return idUzytkownicyRachunki;
    }

    public void setIdUzytkownicyRachunki(Long idUzytkownicyRachunki) {
        this.idUzytkownicyRachunki = idUzytkownicyRachunki;
    }

    public Bill getRachunek() {
        return rachunek;
    }

    public void setRachunek(Bill rachunek) {
        this.rachunek = rachunek;
    }

    public User getUzytkownicyR() {
        return uzytkownicyR;
    }

    public void setUzytkownicyR(User uzytkownicyR) {
        this.uzytkownicyR = uzytkownicyR;
    }
}
