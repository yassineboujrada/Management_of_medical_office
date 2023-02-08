package Models_DB;

//import java.util.Date;

import java.sql.Date;

public class rv {
    private int id;
    private Date jour;

    @Override
    public String toString() {
        return "rv{" +
                "id=" + id +
                ", jour=" + jour +
                ", client=" + client +
                ", creneau=" + creneau +
                '}';
    }

    private clients client;
    private creneaux creneau;

    public rv(int id, Date jour, clients client, creneaux creneau) {
        this.id = id;
        this.jour = jour;
        this.client = client;
        this.creneau = creneau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public clients getClient() {
        return client;
    }

    public void setClient(clients client) {
        this.client = client;
    }

    public creneaux getCreneau() {
        return creneau;
    }

    public void setCreneau(creneaux creneau) {
        this.creneau = creneau;
    }
}
