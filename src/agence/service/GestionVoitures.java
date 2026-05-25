package agence.service;

import agence.interfaces.IRecherchable;
import agence.modele.Voiture;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionVoitures implements IRecherchable {

    private List<Voiture> voitures = new ArrayList<>();

    public void ajouterVoiture(Voiture v) { voitures.add(v); }
    public List<Voiture> getVoitures() { return voitures; }

    public Voiture trouverParId(int id) {
        return voitures.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    public boolean supprimerVoiture(int id) {
        Voiture v = trouverParId(id);
        if (v != null && !v.isDisponible()) {
            return voitures.remove(v);
        }
        System.out.println("Impossible : la voiture est encore disponible ou introuvable.");
        return false;
    }

    public void afficherToutes() {
        if (voitures.isEmpty()) {
            System.out.println("Aucune voiture enregistrée.");
        } else {
            voitures.forEach(System.out::println);
        }
    }

    @Override
    public List<Voiture> rechercherParMarque(String marque) {
        return voitures.stream()
                .filter(v -> v.getMarque().equalsIgnoreCase(marque))
                .collect(Collectors.toList());
    }

    @Override
    public List<Voiture> rechercherParPrixMax(double prixMax) {
        return voitures.stream()
                .filter(v -> v.getPrix() <= prixMax)
                .collect(Collectors.toList());
    }

    public List<Voiture> rechercherParAnneeMin(int anneeMin) {
        return voitures.stream()
                .filter(v -> v.getAnnee() >= anneeMin)
                .collect(Collectors.toList());
    }
}