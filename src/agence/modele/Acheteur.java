package agence.modele;

public class Acheteur extends Personne {

    private double budgetMax;

    public Acheteur(String nom, String prenom, String telephone, String email, double budgetMax) {
        super(nom, prenom, telephone, email);
        this.budgetMax = budgetMax;
    }

    @Override
    public String getRole() { return "ACHETEUR"; }

    public double getBudgetMax() { return budgetMax; }
    public void setBudgetMax(double budgetMax) { this.budgetMax = budgetMax; }

    @Override
    public String toString() {
        return super.toString() + " | Budget max: " + budgetMax + " MAD";
    }
}