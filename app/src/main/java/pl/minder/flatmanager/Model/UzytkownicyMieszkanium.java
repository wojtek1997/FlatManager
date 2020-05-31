
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UzytkownicyMieszkanium {

    @SerializedName("idUzytkownicyMieszkania")
    @Expose
    private Integer idUzytkownicyMieszkania;
    @SerializedName("mieszkania")
    @Expose
    private Mieszkania mieszkania;
    @SerializedName("uzytkownicy")
    @Expose
    private Uzytkownicy uzytkownicy;

    public Integer getIdUzytkownicyMieszkania() {
        return idUzytkownicyMieszkania;
    }

    public void setIdUzytkownicyMieszkania(Integer idUzytkownicyMieszkania) {
        this.idUzytkownicyMieszkania = idUzytkownicyMieszkania;
    }

    public Mieszkania getMieszkania() {
        return mieszkania;
    }

    public void setMieszkania(Mieszkania mieszkania) {
        this.mieszkania = mieszkania;
    }

    public Uzytkownicy getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(Uzytkownicy uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

}
