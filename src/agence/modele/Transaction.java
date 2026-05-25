package agence.modele;

import agence.enums.EtatTransaction;
import agence.enums.EtatAnnonce;

public class Transaction {

    private static int compteur = 1;

    private int id;
    private Annonce annonce;
    private Acheteur acheteur;
    private Agent agent;
    private double montantFinal;
    private EtatTransaction etat;
    private String dateTransaction;

    private static final double TAUX_MEDIATION = 0.03;

    public Transaction(Annonce annonce, Acheteur acheteur, Agent agent,
                       double montantFinal, String dateTransaction) {
        this.id = compteur++;
        this.annonce = annonce;
        this.acheteur = acheteur;
        this.agent = agent;
        this.montantFinal = montantFinal;
        this.etat = EtatTransaction.EN_COURS;
        this.dateTransaction = dateTransaction;
    }

    public double calculerFraisMediation() {
        return montantFinal * TAUX_MEDIATION;
    }

    public void finaliser() {
        this.etat = EtatTransaction.FINALISEE;
        annonce.setEtat(EtatAnnonce.VENDUE);
        annonce.getVoiture().setDisponible(false);
    }

    public void annuler() {
        this.etat = EtatTransaction.ANNULEE;
    }

    public int getId() { return id; }
    public Annonce getAnnonce() { return annonce; }
    public Acheteur getAcheteur() { return acheteur; }
    public Agent getAgent() { return agent; }
    public double getMontantFinal() { return montantFinal; }
    public EtatTransaction getEtat() { return etat; }
    public String getDateTransaction() { return dateTransaction; }

    @Override
    public String toString() {
        return "Transaction #" + id
                + " | Voiture: " + annonce.getVoiture().getMarque() + " " + annonce.getVoiture().getModele()
                + " | Acheteur: " + acheteur.getPrenom() + " " + acheteur.getNom()
                + " | Montant: " + montantFinal + " MAD"
                + " | Frais: " + String.format("%.2f", calculerFraisMediation()) + " MAD"
                + " | État: " + etat
                + " | Date: " + dateTransaction;
    }
}