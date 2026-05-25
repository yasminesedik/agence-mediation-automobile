package agence.modele;

import agence.enums.EtatAnnonce;

public class Annonce {

    private static int compteur = 1;

    private int id;
    private Voiture voiture;
    private Agent agentResponsable;
    private String datePublication;
    private EtatAnnonce etat;
    private String description;

    public Annonce(Voiture voiture, Agent agentResponsable, String datePublication, String description) {
        this.id = compteur++;
        this.voiture = voiture;
        this.agentResponsable = agentResponsable;
        this.datePublication = datePublication;
        this.description = description;
        this.etat = EtatAnnonce.ACTIVE;
    }

    public int getId() { return id; }
    public Voiture getVoiture() { return voiture; }
    public Agent getAgentResponsable() { return agentResponsable; }
    public String getDatePublication() { return datePublication; }
    public EtatAnnonce getEtat() { return etat; }
    public String getDescription() { return description; }

    public void setEtat(EtatAnnonce etat) { this.etat = etat; }
    public void setDescription(String description) { this.description = description; }

    public void desactiver() { this.etat = EtatAnnonce.INACTIVE; }

    @Override
    public String toString() {
        return "Annonce #" + id + " | " + voiture.getMarque() + " " + voiture.getModele()
                + " | Prix: " + voiture.getPrix() + " MAD"
                + " | État: " + etat
                + " | Publiée le: " + datePublication
                + " | Agent: " + agentResponsable.getPrenom() + " " + agentResponsable.getNom();
    }
}