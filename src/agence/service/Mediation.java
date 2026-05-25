package agence.service;

import agence.interfaces.IMediation;
import agence.modele.Annonce;
import agence.modele.Acheteur;
import java.util.ArrayList;
import java.util.List;

public class Mediation implements IMediation {

    private List<String> contacts = new ArrayList<>();
    private List<String> rendezVous = new ArrayList<>();

    @Override
    public void associerAcheteur(Annonce annonce, Acheteur acheteur) {
        System.out.println("Acheteur " + acheteur.getPrenom() + " " + acheteur.getNom()
                + " associé à l'annonce #" + annonce.getId()
                + " (" + annonce.getVoiture().getMarque() + " "
                + annonce.getVoiture().getModele() + ")");
    }

    @Override
    public void enregistrerContact(String details) {
        contacts.add(details);
        System.out.println("Contact enregistré : " + details);
    }

    @Override
    public void planifierRendezVous(String date, String lieu) {
        String rv = "Rendez-vous le " + date + " à " + lieu;
        rendezVous.add(rv);
        System.out.println("Rendez-vous planifié : " + rv);
    }

    public void afficherContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Aucun contact enregistré.");
        } else {
            contacts.forEach(c -> System.out.println(" - " + c));
        }
    }

    public void afficherRendezVous() {
        if (rendezVous.isEmpty()) {
            System.out.println("Aucun rendez-vous planifié.");
        } else {
            rendezVous.forEach(r -> System.out.println(" - " + r));
        }
    }
}