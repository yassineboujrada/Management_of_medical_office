package Models_DB;

public class creneaux {
    private int id,version,hedebut,mdebut,hfin,mfin;

    @Override
    public String toString() {
        return "creneaux{" +
                "id=" + id +
                ", version=" + version +
                ", hedebut=" + hedebut +
                ", mdebut=" + mdebut +
                ", hfin=" + hfin +
                ", mfin=" + mfin +
                ", med=" + med +
                '}';
    }

    private medcins med;
    public creneaux(int id, int version, int hedebut, int mdebut, int hfin, int mfin, medcins med) {
        this.id = id;
        this.version=version;
        this.hedebut = hedebut;
        this.mdebut = mdebut;
        this.hfin = hfin;
        this.mfin = mfin;
        this.med = med;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHedebut() {
        return hedebut;
    }

    public void setHedebut(int hedebut) {
        this.hedebut = hedebut;
    }

    public int getMdebut() {
        return mdebut;
    }

    public void setMdebut(int mdebut) {
        this.mdebut = mdebut;
    }

    public int getHfin() {
        return hfin;
    }

    public void setHfin(int hfin) {
        this.hfin = hfin;
    }

    public int getMfin() {
        return mfin;
    }

    public void setMfin(int mfin) {
        this.mfin = mfin;
    }

    public medcins getMed() {
        return med;
    }

    public void setMed(medcins med) {
        this.med = med;
    }
}
