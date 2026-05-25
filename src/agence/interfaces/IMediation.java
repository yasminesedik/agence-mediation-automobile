package agence.interfaces;

import agence.modele.Annonce;
import agence.modele.Acheteur;

public interface IMediation {
    void associerAcheteur(Annonce annonce, Acheteur acheteur);
    void enregistrerContact(String details);
    void planifierRendezVous(String date, String lieu);
}