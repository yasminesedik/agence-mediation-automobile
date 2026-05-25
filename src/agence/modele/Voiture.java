package agence.modele;

public class Voiture {

    private static int compteur = 1;

    private int id;
    private String marque;
    private String modele;
    private int annee;
    private double kilometrage;
    private double prix;
    private String description;
    private boolean disponible;
    private Vendeur vendeur;

    public Voiture(String marque, String modele, int annee,
                   double kilometrage, double prix, String description, Vendeur vendeur) {
        this.id = compteur++;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.description = description;
        this.disponible = true;
        this.vendeur = vendeur;
    }

    public int getId() { return id; }
    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public int getAnnee() { return annee; }
    public double getKilometrage() { return kilometrage; }
    public double getPrix() { return prix; }
    public String getDescription() { return description; }
    public boolean isDisponible() { return disponible; }
    public Vendeur getVendeur() { return vendeur; }

    public void setMarque(String marque) { this.marque = marque; }
    public void setModele(String modele) { this.modele = modele; }
    public void setAnnee(int annee) { this.annee = annee; }
    public void setKilometrage(double kilometrage) { this.kilometrage = kilometrage; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setDescription(String description) { this.description = description; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Voiture #" + id + " | " + marque + " " + modele + " (" + annee + ")"
                + " | " + kilometrage + " km | " + prix + " MAD"
                + " | " + (disponible ? "Disponible" : "Non disponible")
                + " | Vendeur: " + vendeur.getPrenom() + " " + vendeur.getNom();
    }
}