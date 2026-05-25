package agence.service;

import agence.modele.Vendeur;
import agence.modele.Acheteur;
import agence.modele.Agent;
import java.util.ArrayList;
import java.util.List;

public class GestionPersonnes {

    private List<Vendeur> vendeurs = new ArrayList<>();
    private List<Acheteur> acheteurs = new ArrayList<>();
    private List<Agent> agents = new ArrayList<>();

    // VENDEURS
    public void ajouterVendeur(Vendeur v) { vendeurs.add(v); }
    public List<Vendeur> getVendeurs() { return vendeurs; }

    public Vendeur trouverVendeurParId(int id) {
        return vendeurs.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    public boolean supprimerVendeur(int id) {
        return vendeurs.removeIf(v -> v.getId() == id);
    }

    // ACHETEURS
    public void ajouterAcheteur(Acheteur a) { acheteurs.add(a); }
    public List<Acheteur> getAcheteurs() { return acheteurs; }

    public Acheteur trouverAcheteurParId(int id) {
        return acheteurs.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public boolean supprimerAcheteur(int id) {
        return acheteurs.removeIf(a -> a.getId() == id);
    }

    // AGENTS
    public void ajouterAgent(Agent ag) { agents.add(ag); }
    public List<Agent> getAgents() { return agents; }

    public Agent trouverAgentParId(int id) {
        return agents.stream().filter(ag -> ag.getId() == id).findFirst().orElse(null);
    }

    public boolean supprimerAgent(int id) {
        return agents.removeIf(ag -> ag.getId() == id);
    }

    public void afficherToutesPersonnes() {
        System.out.println("\n--- Vendeurs ---");
        vendeurs.forEach(System.out::println);
        System.out.println("\n--- Acheteurs ---");
        acheteurs.forEach(System.out::println);
        System.out.println("\n--- Agents ---");
        agents.forEach(System.out::println);
    }
}