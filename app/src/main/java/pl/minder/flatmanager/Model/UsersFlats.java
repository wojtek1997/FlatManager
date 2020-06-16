package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersFlats {

    @SerializedName("idUzytkownicyMieszkania")
    @Expose
    private Long idUzytkownicyMieszkania;
    @SerializedName("mieszkania")
    @Expose
    private Flat mieszkania;
    @SerializedName("uzytkownicy")
    @Expose
    private User uzytkownicy;

    public Long getIdUzytkownicyMieszkania() {
        return idUzytkownicyMieszkania;
    }

    public void setIdUzytkownicyMieszkania(Long idUzytkownicyMieszkania) {
        this.idUzytkownicyMieszkania = idUzytkownicyMieszkania;
    }

    public Flat getMieszkania() {
        return mieszkania;
    }

    public void setMieszkania(Flat mieszkania) {
        this.mieszkania = mieszkania;
    }

    public User getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(User uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }
}
