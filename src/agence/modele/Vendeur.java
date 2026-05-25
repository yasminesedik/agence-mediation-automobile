package agence.modele;

public class Vendeur extends Personne {

    private String adresse;

    public Vendeur(String nom, String prenom, String telephone, String email, String adresse) {
        super(nom, prenom, telephone, email);
        this.adresse = adresse;
    }

    @Override
    public String getRole() { return "VENDEUR"; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    @Override
    public String toString() {
        return super.toString() + " | Adresse: " + adresse;
    }
}