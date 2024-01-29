public class ScenarioEtudiant {
    public static void main(String[] args) {
        double[] coefficients = {3, 2, 1, 2, 3};
        String[] matiere = {"Math", "Chimie", "Histoire", "Philo", "Francais"};

        Etudiant etudiantRomain = new Etudiant("Romain", matiere, coefficients, 3);
        Etudiant etudiantOmer = new Etudiant("Omer", matiere, coefficients, 3);
        Etudiant etudiantMael = new Etudiant("Mael", matiere, coefficients, 3);
        Etudiant etudiantRayanne = new Etudiant("Rayanne", matiere, coefficients, 3);
        Etudiant etudiantNoe = new Etudiant("Noe", matiere, coefficients, 3);

        // Afficher le bulletin de chaque étudiant
        etudiantRomain.bulletinEtudiant();
        etudiantOmer.bulletinEtudiant();
        etudiantMael.bulletinEtudiant();
        etudiantRayanne.bulletinEtudiant();
        etudiantNoe.bulletinEtudiant();

        // Calculer et afficher la moyenne de la classe
        double moyenneClasse = calculerMoyenneClasse(etudiantRomain, etudiantOmer, etudiantMael, etudiantRayanne, etudiantNoe);
        System.out.println("Moyenne de la classe: " + moyenneClasse);

        // Trouver l'étudiant avec la meilleure moyenne
        Etudiant meilleurEtudiant = trouverMeilleurEtudiant(etudiantRomain, etudiantOmer, etudiantMael, etudiantRayanne, etudiantNoe);
        System.out.println("Meilleur étudiant: " + meilleurEtudiant.getNom() + " avec une moyenne de " + meilleurEtudiant.moyenneGenerale());

        // Trouver l'étudiant avec la pire moyenne
        Etudiant pireEtudiant = trouverPireEtudiant(etudiantRomain, etudiantOmer, etudiantMael, etudiantRayanne, etudiantNoe);
        System.out.println("Pire étudiant: " + pireEtudiant.getNom() + " avec une moyenne de " + pireEtudiant.moyenneGenerale());
    }

    private static double calculerMoyenneClasse(Etudiant... etudiants) {
        double sommeMoyennes = 0;
        int nombreEtudiants = etudiants.length;

        for (Etudiant etudiant : etudiants) {
            sommeMoyennes += etudiant.moyenneGenerale();
        }

        return sommeMoyennes / nombreEtudiants;
    }

    private static Etudiant trouverMeilleurEtudiant(Etudiant... etudiants) {
        Etudiant meilleurEtudiant = etudiants[0];

        for (Etudiant etudiant : etudiants) {
            if (etudiant.moyenneGenerale() > meilleurEtudiant.moyenneGenerale()) {
                meilleurEtudiant = etudiant;
            }
        }

        return meilleurEtudiant;
    }

    private static Etudiant trouverPireEtudiant(Etudiant... etudiants) {
        Etudiant pireEtudiant = etudiants[0];

        for (Etudiant etudiant : etudiants) {
            if (etudiant.moyenneGenerale() < pireEtudiant.moyenneGenerale()) {
                pireEtudiant = etudiant;
            }
        }

        return pireEtudiant;
    }
}
