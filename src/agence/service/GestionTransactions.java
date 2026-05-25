package agence.service;

import agence.modele.Transaction;
import java.util.ArrayList;
import java.util.List;

public class GestionTransactions {

    private List<Transaction> transactions = new ArrayList<>();

    public void creerTransaction(Transaction t) { transactions.add(t); }
    public List<Transaction> getTransactions() { return transactions; }

    public Transaction trouverParId(int id) {
        return transactions.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public void finaliserTransaction(int id) {
        Transaction t = trouverParId(id);
        if (t != null) {
            t.finaliser();
            System.out.println("Transaction #" + id + " finalisée !");
            System.out.printf("Frais de médiation : %.2f MAD%n", t.calculerFraisMediation());
        } else {
            System.out.println("Transaction introuvable.");
        }
    }

    public void annulerTransaction(int id) {
        Transaction t = trouverParId(id);
        if (t != null) {
            t.annuler();
            System.out.println("Transaction #" + id + " annulée.");
        } else {
            System.out.println("Transaction introuvable.");
        }
    }

    public void afficherTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Aucune transaction enregistrée.");
        } else {
            transactions.forEach(System.out::println);
        }
    }

    public void afficherBilanFrais() {
        double total = transactions.stream()
                .mapToDouble(Transaction::calculerFraisMediation)
                .sum();
        System.out.printf("Total frais de médiation : %.2f MAD%n", total);
    }
}