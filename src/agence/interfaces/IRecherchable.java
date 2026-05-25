package agence.interfaces;

import agence.modele.Voiture;
import java.util.List;

public interface IRecherchable {
    List<Voiture> rechercherParMarque(String marque);
    List<Voiture> rechercherParPrixMax(double prixMax);
}