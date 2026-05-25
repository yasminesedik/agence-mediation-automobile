package agence.modele;

public class Agent extends Personne {

    private String matricule;
    private int nombreDossiers;

    public Agent(String nom, String prenom, String telephone, String email, String matricule) {
        super(nom, prenom, telephone, email);
        this.matricule = matricule;
        this.nombreDossiers = 0;
    }

    @Override
    public String getRole() { return "AGENT"; }

    public String getMatricule() { return matricule; }
    public int getNombreDossiers() { return nombreDossiers; }
    public void incrementerDossiers() { this.nombreDossiers++; }

    @Override
    public String toString() {
        return super.toString() + " | Matricule: " + matricule + " | Dossiers: " + nombreDossiers;
    }
}