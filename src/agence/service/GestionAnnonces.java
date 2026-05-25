package agence.service;

import agence.enums.EtatAnnonce;
import agence.modele.Annonce;
import java.util.ArrayList;
import java.util.List;

public class GestionAnnonces {

    private List<Annonce> annonces = new ArrayList<>();

    public void creerAnnonce(Annonce a) { annonces.add(a); }
    public List<Annonce> getAnnonces() { return annonces; }

    public Annonce trouverParId(int id) {
        return annonces.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public void afficherAnnonces() {
        if (annonces.isEmpty()) {
            System.out.println("Aucune annonce disponible.");
        } else {
            annonces.forEach(System.out::println);
        }
    }

    public void afficherAnnoncesActives() {
        annonces.stream()
                .filter(a -> a.getEtat() == EtatAnnonce.ACTIVE)
                .forEach(System.out::println);
    }

    public void desactiverAnnonce(int id) {
        Annonce a = trouverParId(id);
        if (a != null) {
            a.desactiver();
            System.out.println("Annonce #" + id + " désactivée.");
        } else {
            System.out.println("Annonce introuvable.");
        }
    }
}