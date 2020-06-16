package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersEvents {

    @SerializedName("idUzytkownicyZdarzenia")
    @Expose
    private Long idUzytkownicyZdarzenia;
    @SerializedName("zdarzenie")
    @Expose
    private Event zdarzenie;
    @SerializedName("uzytkownicyZ")
    @Expose
    private User uzytkownicyZ;

    public Long getIdUzytkownicyZdarzenia() {
        return idUzytkownicyZdarzenia;
    }

    public void setIdUzytkownicyZdarzenia(Long idUzytkownicyZdarzenia) {
        this.idUzytkownicyZdarzenia = idUzytkownicyZdarzenia;
    }

    public Event getZdarzenie() {
        return zdarzenie;
    }

    public void setZdarzenie(Event zdarzenie) {
        this.zdarzenie = zdarzenie;
    }

    public User getUzytkownicyZ() {
        return uzytkownicyZ;
    }

    public void setUzytkownicyZ(User uzytkownicyZ) {
        this.uzytkownicyZ = uzytkownicyZ;
    }
}
