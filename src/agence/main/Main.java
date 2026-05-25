package agence.main;

import agence.enums.*;
import agence.modele.*;
import agence.service.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    static GestionPersonnes gPersonnes = new GestionPersonnes();
    static GestionVoitures gVoitures = new GestionVoitures();
    static GestionAnnonces gAnnonces = new GestionAnnonces();
    static GestionDemandes gDemandes = new GestionDemandes();
    static GestionTransactions gTransactions = new GestionTransactions();
    static Mediation mediation = new Mediation();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        chargerDonneesTest();
        int choix;
        do {
            afficherMenuPrincipal();
            choix = lireInt();
            switch (choix) {
                case 1 -> menuPersonnes();
                case 2 -> menuVoitures();
                case 3 -> menuAnnonces();
                case 4 -> menuDemandes();
                case 5 -> menuMediation();
                case 6 -> menuTransactions();
                case 7 -> menuRecherche();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    static void afficherMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     AGENCE DE MÉDIATION AUTOMOBILE     ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Gestion des personnes              ║");
        System.out.println("║  2. Gestion des voitures               ║");
        System.out.println("║  3. Gestion des annonces               ║");
        System.out.println("║  4. Gestion des demandes               ║");
        System.out.println("║  5. Médiation                          ║");
        System.out.println("║  6. Transactions & frais               ║");
        System.out.println("║  7. Recherche                          ║");
        System.out.println("║  0. Quitter                            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Votre choix : ");
    }

    static void menuPersonnes() {
        System.out.println("\n--- Gestion des personnes ---");
        System.out.println("1. Ajouter un vendeur");
        System.out.println("2. Ajouter un acheteur");
        System.out.println("3. Ajouter un agent");
        System.out.println("4. Afficher toutes les personnes");
        System.out.println("5. Supprimer un vendeur");
        System.out.println("6. Supprimer un acheteur");
        System.out.print("Choix : ");
        int c = lireInt();
        switch (c) {
            case 1 -> {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Prénom: "); String prenom = sc.nextLine();
                System.out.print("Téléphone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Adresse: "); String adr = sc.nextLine();
                Vendeur v = new Vendeur(nom, prenom, tel, email, adr);
                gPersonnes.ajouterVendeur(v);
                System.out.println("Vendeur ajouté : " + v);
            }
            case 2 -> {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Prénom: "); String prenom = sc.nextLine();
                System.out.print("Téléphone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Budget max (MAD): "); double budget = lireDouble();
                Acheteur a = new Acheteur(nom, prenom, tel, email, budget);
                gPersonnes.ajouterAcheteur(a);
                System.out.println("Acheteur ajouté : " + a);
            }
            case 3 -> {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Prénom: "); String prenom = sc.nextLine();
                System.out.print("Téléphone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Matricule: "); String mat = sc.nextLine();
                Agent ag = new Agent(nom, prenom, tel, email, mat);
                gPersonnes.ajouterAgent(ag);
                System.out.println("Agent ajouté : " + ag);
            }
            case 4 -> gPersonnes.afficherToutesPersonnes();
            case 5 -> {
                System.out.print("ID du vendeur à supprimer: ");
                int id = lireInt();
                System.out.println(gPersonnes.supprimerVendeur(id) ? "Vendeur supprimé." : "Introuvable.");
            }
            case 6 -> {
                System.out.print("ID de l'acheteur à supprimer: ");
                int id = lireInt();
                System.out.println(gPersonnes.supprimerAcheteur(id) ? "Acheteur supprimé." : "Introuvable.");
            }
            default -> System.out.println("Choix invalide.");
        }
    }

    static void menuVoitures() {
        System.out.println("\n--- Gestion des voitures ---");
        System.out.println("1. Ajouter une voiture");
        System.out.println("2. Afficher toutes les voitures");
        System.out.println("3. Modifier le prix d'une voiture");
        System.out.println("4. Supprimer une voiture");
        System.out.print("Choix : ");
        int c = lireInt();
        switch (c) {
            case 1 -> {
                System.out.print("Marque: "); String marque = sc.nextLine();
                System.out.print("Modèle: "); String modele = sc.nextLine();
                System.out.print("Année: "); int annee = lireInt();
                System.out.print("Kilométrage: "); double km = lireDouble();
                System.out.print("Prix (MAD): "); double prix = lireDouble();
                System.out.print("Description: "); String desc = sc.nextLine();
                System.out.print("ID du vendeur: "); int idV = lireInt();
                Vendeur vendeur = gPersonnes.trouverVendeurParId(idV);
                if (vendeur == null) {
                    System.out.println("Vendeur introuvable.");
                } else {
                    Voiture voiture = new Voiture(marque, modele, annee, km, prix, desc, vendeur);
                    gVoitures.ajouterVoiture(voiture);
                    System.out.println("Voiture ajoutée : " + voiture);
                }
            }
            case 2 -> gVoitures.afficherToutes();
            case 3 -> {
                System.out.print("ID de la voiture: "); int id = lireInt();
                Voiture v = gVoitures.trouverParId(id);
                if (v != null) {
                    System.out.print("Nouveau prix (MAD): "); double prix = lireDouble();
                    v.setPrix(prix);
                    System.out.println("Prix mis à jour.");
                } else {
                    System.out.println("Voiture introuvable.");
                }
            }
            case 4 -> {
                System.out.print("ID de la voiture: "); int id = lireInt();
                gVoitures.supprimerVoiture(id);
            }
            default -> System.out.println("Choix invalide.");
        }
    }

    static void menuAnnonces() {
        System.out.println("\n--- Gestion des annonces ---");
        System.out.println("1. Créer une annonce");
        System.out.println("2. Afficher toutes les annonces");
        System.out.println("3. Afficher les annonces actives");
        System.out.println("4. Désactiver une annonce");
        System.out.print("Choix : ");
        int c = lireInt();
        switch (c) {
            case 1 -> {
                System.out.print("ID de la voiture: "); int idVoiture = lireInt();
                System.out.print("ID de l'agent: "); int idAgent = lireInt();
                System.out.print("Date (ex: 2026-05-14): "); String date = sc.nextLine();
                System.out.print("Description: "); String desc = sc.nextLine();
                Voiture v = gVoitures.trouverParId(idVoiture);
                Agent ag = gPersonnes.trouverAgentParId(idAgent);
                if (v == null || ag == null) {
                    System.out.println("Voiture ou agent introuvable.");
                } else {
                    Annonce annonce = new Annonce(v, ag, date, desc);
                    gAnnonces.creerAnnonce(annonce);
                    ag.incrementerDossiers();
                    System.out.println("Annonce créée : " + annonce);
                }
            }
            case 2 -> gAnnonces.afficherAnnonces();
            case 3 -> gAnnonces.afficherAnnoncesActives();
            case 4 -> {
                System.out.print("ID de l'annonce: "); int id = lireInt();
                gAnnonces.desactiverAnnonce(id);
            }
            default -> System.out.println("Choix invalide.");
        }
    }

    static void menuDemandes() {
        System.out.println("\n--- Gestion des demandes ---");
        System.out.println("1. Enregistrer une demande");
        System.out.println("2. Afficher toutes les demandes");
        System.out.println("3. Associer une voiture à une demande");
        System.out.println("4. Modifier l'état d'une demande");
        System.out.print("Choix : ");
        int c = lireInt();
        switch (c) {
            case 1 -> {
                System.out.print("ID de l'acheteur: "); int idA = lireInt();
                Acheteur a = gPersonnes.trouverAcheteurParId(idA);
                if (a == null) { System.out.println("Acheteur introuvable."); return; }
                System.out.print("Marque recherchée: "); String marque = sc.nextLine();
                System.out.print("Budget max (MAD): "); double budget = lireDouble();
                System.out.print("Date: "); String date = sc.nextLine();
                DemandeAchat d = new DemandeAchat(a, marque, budget, date);
                gDemandes.enregistrerDemande(d);
                System.out.println("Demande enregistrée : " + d);
            }
            case 2 -> gDemandes.afficherDemandes();
            case 3 -> {
                System.out.print("ID de la demande: "); int idD = lireInt();
                System.out.print("ID de la voiture: "); int idV = lireInt();
                Voiture v = gVoitures.trouverParId(idV);
                if (v == null) { System.out.println("Voiture introuvable."); return; }
                gDemandes.associerVoiture(idD, v);
            }
            case 4 -> {
                System.out.print("ID de la demande: "); int id = lireInt();
                System.out.println("1=EN_ATTENTE  2=EN_COURS  3=SATISFAITE  4=ANNULEE");
                int e = lireInt();
                EtatDemande etat = switch (e) {
                    case 1 -> EtatDemande.EN_ATTENTE;
                    case 2 -> EtatDemande.EN_COURS;
                    case 3 -> EtatDemande.SATISFAITE;
                    case 4 -> EtatDemande.ANNULEE;
                    default -> null;
                };
                if (etat != null) gDemandes.changerEtat(id, etat);
                else System.out.println("État invalide.");
            }
            default -> System.out.println("Choix invalide.");
        }
    }

    static void menuMediation() {
        System.out.println("\n--- Médiation ---");
        System.out.println("1. Associer un acheteur à une annonce");
        System.out.println("2. Enregistrer une prise de contact");
        System.out.println("3. Planifier un rendez-vous");
        System.out.println("4. Afficher les contacts");
        System.out.println("5. Afficher les rendez-vous");
        System.out.print("Choix : ");
        int c = lireInt();
        switch (c) {
            case 1 -> {
                System.out.print("ID de l'annonce: "); int idA = lireInt();
                System.out.print("ID de l'acheteur: "); int idAch = lireInt();
                Annonce ann = gAnnonces.trouverParId(idA);
                Acheteur ach = gPersonnes.trouverAcheteurParId(idAch);
                if (ann == null || ach == null) { System.out.println("Données introuvables."); return; }
                mediation.associerAcheteur(ann, ach);
            }
            case 2 -> {
                System.out.print("Détails du contact: "); String details = sc.nextLine();
                mediation.enregistrerContact(details);
            }
            case 3 -> {
                System.out.print("Date: "); String date = sc.nextLine();
                System.out.print("Lieu: "); String lieu = sc.nextLine();
                mediation.planifierRendezVous(date, lieu);
            }
            case 4 -> mediation.afficherContacts();
            case 5 -> mediation.afficherRendezVous();
            default -> System.out.println("Choix invalide.");
        }
    }

    static void menuTransactions() {
        System.out.println("\n--- Transactions & Frais ---");
        System.out.println("1. Créer une transaction");
        System.out.println("2. Afficher toutes les transactions");
        System.out.println("3. Finaliser une transaction");
        System.out.println("4. Annuler une transaction");
        System.out.println("5. Bilan des frais de médiation");
        System.out.print("Choix : ");
        int c = lireInt();
        switch (c) {
            case 1 -> {
                System.out.print("ID de l'annonce: "); int idAnn = lireInt();
                System.out.print("ID de l'acheteur: "); int idAch = lireInt();
                System.out.print("ID de l'agent: "); int idAg = lireInt();
                System.out.print("Montant final (MAD): "); double montant = lireDouble();
                System.out.print("Date: "); String date = sc.nextLine();
                Annonce ann = gAnnonces.trouverParId(idAnn);
                Acheteur ach = gPersonnes.trouverAcheteurParId(idAch);
                Agent ag = gPersonnes.trouverAgentParId(idAg);
                if (ann == null || ach == null || ag == null) {
                    System.out.println("Données introuvables.");
                } else {
                    Transaction t = new Transaction(ann, ach, ag, montant, date);
                    gTransactions.creerTransaction(t);
                    System.out.println("Transaction créée : " + t);
                }
            }
            case 2 -> gTransactions.afficherTransactions();
            case 3 -> { System.out.print("ID: "); gTransactions.finaliserTransaction(lireInt()); }
            case 4 -> { System.out.print("ID: "); gTransactions.annulerTransaction(lireInt()); }
            case 5 -> gTransactions.afficherBilanFrais();
            default -> System.out.println("Choix invalide.");
        }
    }

    static void menuRecherche() {
        System.out.println("\n--- Recherche ---");
        System.out.println("1. Par marque");
        System.out.println("2. Par prix maximum");
        System.out.println("3. Par année minimum");
        System.out.print("Choix : ");
        int c = lireInt();
        List<Voiture> resultats;
        switch (c) {
            case 1 -> {
                System.out.print("Marque: "); String m = sc.nextLine();
                resultats = gVoitures.rechercherParMarque(m);
                afficherResultats(resultats);
            }
            case 2 -> {
                System.out.print("Prix maximum (MAD): "); double p = lireDouble();
                resultats = gVoitures.rechercherParPrixMax(p);
                afficherResultats(resultats);
            }
            case 3 -> {
                System.out.print("Année minimum: "); int a = lireInt();
                resultats = gVoitures.rechercherParAnneeMin(a);
                afficherResultats(resultats);
            }
            default -> System.out.println("Choix invalide.");
        }
    }

    static void afficherResultats(List<Voiture> resultats) {
        if (resultats.isEmpty()) {
            System.out.println("Aucun résultat.");
        } else {
            System.out.println(resultats.size() + " résultat(s) :");
            resultats.forEach(System.out::println);
        }
    }

    static void chargerDonneesTest() {
        Vendeur v1 = new Vendeur("Alami", "Youssef", "0661000001", "youssef@mail.ma", "Casablanca");
        Vendeur v2 = new Vendeur("Benali", "Sara", "0662000002", "sara@mail.ma", "Rabat");
        gPersonnes.ajouterVendeur(v1);
        gPersonnes.ajouterVendeur(v2);

        Acheteur a1 = new Acheteur("Idrissi", "Karim", "0663000003", "karim@mail.ma", 150000);
        Acheteur a2 = new Acheteur("Chaoui", "Nadia", "0664000004", "nadia@mail.ma", 80000);
        gPersonnes.ajouterAcheteur(a1);
        gPersonnes.ajouterAcheteur(a2);

        Agent ag1 = new Agent("Rahali", "Omar", "0665000005", "omar@agence.ma", "AG-001");
        gPersonnes.ajouterAgent(ag1);

        Voiture voit1 = new Voiture("Dacia", "Logan", 2019, 75000, 95000, "Bon état", v1);
        Voiture voit2 = new Voiture("Toyota", "Yaris", 2021, 30000, 145000, "Comme neuf", v2);
        Voiture voit3 = new Voiture("Renault", "Clio", 2018, 90000, 72000, "Climatisée", v1);
        gVoitures.ajouterVoiture(voit1);
        gVoitures.ajouterVoiture(voit2);
        gVoitures.ajouterVoiture(voit3);

        Annonce ann1 = new Annonce(voit1, ag1, "2026-05-01", "Dacia Logan à vendre");
        Annonce ann2 = new Annonce(voit2, ag1, "2026-05-05", "Toyota Yaris quasi neuve");
        gAnnonces.creerAnnonce(ann1);
        gAnnonces.creerAnnonce(ann2);
        ag1.incrementerDossiers();
        ag1.incrementerDossiers();

        System.out.println("Données de test chargées !");
    }

    static int lireInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrez un entier : ");
            }
        }
    }

    static double lireDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrez un nombre : ");
            }
        }
    }
}
