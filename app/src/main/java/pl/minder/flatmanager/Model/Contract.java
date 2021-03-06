package pl.minder.flatmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contract {

    @SerializedName("idUmowy")
    @Expose
    private Long idUmowy;
    @SerializedName("dataZawarcia")
    @Expose
    private String dataZawarcia;
    @SerializedName("dataZakonczenia")
    @Expose
    private String dataZakonczenia;
    @SerializedName("kaucja")
    @Expose
    private Double kaucja;
    @SerializedName("czynsz")
    @Expose
    private Double czynsz;
    @SerializedName("okresWypowiedzenia")
    @Expose
    private Integer okresWypowiedzenia;
    @SerializedName("mieszkanie")
    @Expose
    private Flat mieszkanie;

    public Long getIdUmowy() {
        return idUmowy;
    }

    public void setIdUmowy(Long idUmowy) {
        this.idUmowy = idUmowy;
    }

    public String getDataZawarcia() {
        return dataZawarcia;
    }

    public void setDataZawarcia(String dataZawarcia) {
        this.dataZawarcia = dataZawarcia;
    }

    public String getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(String dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public Double getKaucja() {
        return kaucja;
    }

    public void setKaucja(Double kaucja) {
        this.kaucja = kaucja;
    }

    public Double getCzynsz() {
        return czynsz;
    }

    public void setCzynsz(Double czynsz) {
        this.czynsz = czynsz;
    }

    public Integer getOkresWypowiedzenia() {
        return okresWypowiedzenia;
    }

    public void setOkresWypowiedzenia(Integer okresWypowiedzenia) {
        this.okresWypowiedzenia = okresWypowiedzenia;
    }

    public Flat getMieszkanie() {
        return mieszkanie;
    }

    public void setMieszkanie(Flat mieszkanie) {
        this.mieszkanie = mieszkanie;
    }
}
