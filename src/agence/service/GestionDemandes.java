package agence.service;

import agence.enums.EtatDemande;
import agence.modele.DemandeAchat;
import agence.modele.Voiture;
import java.util.ArrayList;
import java.util.List;

public class GestionDemandes {

    private List<DemandeAchat> demandes = new ArrayList<>();

    public void enregistrerDemande(DemandeAchat d) { demandes.add(d); }
    public List<DemandeAchat> getDemandes() { return demandes; }

    public DemandeAchat trouverParId(int id) {
        return demandes.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public void afficherDemandes() {
        if (demandes.isEmpty()) {
            System.out.println("Aucune demande enregistrée.");
        } else {
            demandes.forEach(System.out::println);
        }
    }

    public void changerEtat(int id, EtatDemande nouvelEtat) {
        DemandeAchat d = trouverParId(id);
        if (d != null) {
            d.setEtat(nouvelEtat);
            System.out.println("État mis à jour : " + nouvelEtat);
        } else {
            System.out.println("Demande introuvable.");
        }
    }

    public void associerVoiture(int idDemande, Voiture v) {
        DemandeAchat d = trouverParId(idDemande);
        if (d != null) {
            d.ajouterVoiture(v);
            System.out.println("Voiture associée à la demande #" + idDemande);
        } else {
            System.out.println("Demande introuvable.");
        }
    }
}