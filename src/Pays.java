import java.util.ArrayList;
import java.util.List;

public class Pays implements Comparable<Pays> {
    private List<Athlete> listeAthlete;
    private String nom;
    private int nbOr = 0;
    private int nbArgent = 0;
    private int nbBronze = 0;

    public Pays(List<Athlete> list, String nom) {
        this.listeAthlete = list;
        this.nom = nom;
    }

    public Pays(String nom) {
        this.listeAthlete = new ArrayList<>();
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }
    
    public void ajouterAthlete(Athlete athlete) {
        if (athlete.getPays().equals(this) && !listeAthlete.contains(athlete)) {
            this.listeAthlete.add(athlete);
        }
    }

    public int nbMedaillesTot() {
        return this.nbOr + this.nbArgent + this.nbBronze;
    }

    public void ajouterOr() {
        nbOr++;
    }

    public void ajouterArgent() {
        nbArgent++;
    }

    public void ajouterBronze() {
        nbBronze++;
    }

    public void ajouterMedaille(String medaille) {
        switch(medaille) {
            case "Or":
                nbOr++;
                break;
            case "Argent":
                nbArgent++;
                break;
            case "Bronze":
                nbBronze++;
                break;
        }
    }

    @Override
    public String toString() {
        return "Pays [nom = " + nom + ", nbMedailles = " + this.nbMedaillesTot() + "]";
    }

    @Override
    public int compareTo(Pays other) {
        return other.nbMedaillesTot() - this.nbMedaillesTot();
    }
    
}
