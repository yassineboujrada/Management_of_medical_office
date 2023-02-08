package Models_DB;

public class clients {
    private int id,version;
    private String titre,nom,prenom;

    public clients(int id, int version, String titre, String nom, String prenom) {
        this.id = id;
        this.version = version;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "clients{" +
                "id=" + id +
                ", version=" + version +
                ", titre='" + titre + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
