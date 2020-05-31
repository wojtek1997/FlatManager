
package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UzytkownicyRachunki {

    @SerializedName("idUzytkownicyRachunki")
    @Expose
    private Integer idUzytkownicyRachunki;
    @SerializedName("rachunek")
    @Expose
    private Rachunek rachunek;
    @SerializedName("uzytkownicyR")
    @Expose
    private UzytkownicyR uzytkownicyR;

    public Integer getIdUzytkownicyRachunki() {
        return idUzytkownicyRachunki;
    }

    public void setIdUzytkownicyRachunki(Integer idUzytkownicyRachunki) {
        this.idUzytkownicyRachunki = idUzytkownicyRachunki;
    }

    public Rachunek getRachunek() {
        return rachunek;
    }

    public void setRachunek(Rachunek rachunek) {
        this.rachunek = rachunek;
    }

    public UzytkownicyR getUzytkownicyR() {
        return uzytkownicyR;
    }

    public void setUzytkownicyR(UzytkownicyR uzytkownicyR) {
        this.uzytkownicyR = uzytkownicyR;
    }

}
