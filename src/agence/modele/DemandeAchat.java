package agence.modele;

import agence.enums.EtatDemande;
import java.util.ArrayList;
import java.util.List;

public class DemandeAchat {

    private static int compteur = 1;

    private int id;
    private Acheteur acheteur;
    private String marqueRecherchee;
    private double budgetMax;
    private EtatDemande etat;
    private List<Voiture> voituresAssociees;
    private String dateDemande;

    public DemandeAchat(Acheteur acheteur, String marqueRecherchee, double budgetMax, String dateDemande) {
        this.id = compteur++;
        this.acheteur = acheteur;
        this.marqueRecherchee = marqueRecherchee;
        this.budgetMax = budgetMax;
        this.etat = EtatDemande.EN_ATTENTE;
        this.voituresAssociees = new ArrayList<>();
        this.dateDemande = dateDemande;
    }

    public void ajouterVoiture(Voiture v) { voituresAssociees.add(v); }

    public int getId() { return id; }
    public Acheteur getAcheteur() { return acheteur; }
    public String getMarqueRecherchee() { return marqueRecherchee; }
    public double getBudgetMax() { return budgetMax; }
    public EtatDemande getEtat() { return etat; }
    public List<Voiture> getVoituresAssociees() { return voituresAssociees; }
    public String getDateDemande() { return dateDemande; }

    public void setEtat(EtatDemande etat) { this.etat = etat; }

    @Override
    public String toString() {
        return "Demande #" + id + " | Acheteur: " + acheteur.getPrenom() + " " + acheteur.getNom()
                + " | Marque: " + marqueRecherchee + " | Budget: " + budgetMax + " MAD"
                + " | État: " + etat + " | Date: " + dateDemande;
    }
}