import java.util.ArrayList;
import java.util.List;

public class ScenarioEtudiant {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        bulletinClasse();

     // ! Si dessus on va avoir les methodes de test unitaire pour chaque methode de la classe Etudiant. Il sont sous commentaires.
        
    
    }

    public static void bulletinClasse(){
        double[] coefficients = {3, 2, 1, 2, 3};
        String[] matiere = {"Math", "Chimie", "Histoire", "Philo", "Francais"};
        List<Etudiant> listeEtudiant = new ArrayList<>();

        Etudiant etudiantRomain = new Etudiant("Romain", matiere, coefficients, 3);
        Etudiant etudiantOmer = new Etudiant("Omer", matiere, coefficients, 3);
        Etudiant etudiantMael = new Etudiant("Mael", matiere, coefficients, 3);
        Etudiant etudiantRayanne = new Etudiant("Rayanne", matiere, coefficients, 3);
        Etudiant etudiantNoe = new Etudiant("Noe", matiere, coefficients, 3);
        Etudiant etudiantBrayan = new Etudiant("Brayan", matiere, coefficients, 3);

        // Afficher le bulletin de chaque étudiant
        etudiantRomain.bulletinEtudiant();
        etudiantOmer.bulletinEtudiant();
        etudiantMael.bulletinEtudiant();
        etudiantRayanne.bulletinEtudiant();
        etudiantNoe.bulletinEtudiant();
        etudiantBrayan.bulletinEtudiant();

        listeEtudiant.add(etudiantRomain);
        listeEtudiant.add(etudiantOmer);
        listeEtudiant.add(etudiantMael);
        listeEtudiant.add(etudiantRayanne);
        listeEtudiant.add(etudiantNoe);
        listeEtudiant.add(etudiantBrayan);


        // Calculer et afficher la moyenne de la classe
        double moyenneClasse = calculerMoyenneClasse(listeEtudiant);
        System.out.println("Moyenne de la classe: " + moyenneClasse);

        // Trouver l'étudiant avec la meilleure moyenne
        Etudiant meilleurEtudiant = trouverMeilleurEtudiant(listeEtudiant);
        System.out.println("Meilleur étudiant: " + meilleurEtudiant.getNom() + " avec une moyenne de " + meilleurEtudiant.moyenneGenerale());

        // Trouver l'étudiant avec la pire moyenne
        Etudiant pireEtudiant = trouverPireEtudiant(listeEtudiant);
        System.out.println("Pire étudiant: " + pireEtudiant.getNom() + " avec une moyenne de " + pireEtudiant.moyenneGenerale());
    }

    private static double calculerMoyenneClasse(List<Etudiant> listeEtudiant) {
        double sommeMoyennes = 0;
        double moyenneClasse = 0;
        int nombreEtudiants = listeEtudiant.size();

        for (int i = 0; i < listeEtudiant.size(); i++) {
            sommeMoyennes += listeEtudiant.get(i).moyenneGenerale();
        }

        moyenneClasse = sommeMoyennes / nombreEtudiants;
        return moyenneClasse;
    }

    private static Etudiant trouverMeilleurEtudiant(List<Etudiant> listeEtudiants) {
        Etudiant meilleurEtudiant = listeEtudiants.get(0);

        for (int i = 0; i < listeEtudiants.size(); i++) {
            if (listeEtudiants.get(i).moyenneGenerale() > meilleurEtudiant.moyenneGenerale()) {
                meilleurEtudiant = listeEtudiants.get(i);
            }
        }

        return(meilleurEtudiant);
    }

    private static Etudiant trouverPireEtudiant(List<Etudiant> listeEtudiants) {
        Etudiant pireEtudiant = listeEtudiants.get(0);

        for (int i = 0; i < listeEtudiants.size(); i++) {
            if (listeEtudiants.get(i).moyenneGenerale() < pireEtudiant.moyenneGenerale()) {
                pireEtudiant = listeEtudiants.get(i);
            }
        }

        return pireEtudiant;
    }

}
