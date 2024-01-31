/*
* @author O.Gunes
*/
public class Etudiant {
    private String nom;
    private double[][] bulletin;
    private String[] MATIERES;
    private double[] COEFFICIANTS;

    public Etudiant(String nom, String[] matiere, double[] coeff, int nbNotes){
        
        if(nom != null && matiere != null && coeff != null && nbNotes >= 0){
            this.nom = nom;
            if(matiere.length == coeff.length){
                this.MATIERES = matiere;
                this.COEFFICIANTS = coeff;
                this.bulletin = new double[this.MATIERES.length][nbNotes];
                initialisation();
            } else {
                System.out.println("Constructeur : Erreur");
            } 
        } else {
            System.out.println("Constructeur : Erreur");
        }
    }

    
    /** 
     * @param nom
     */
    public void setNom(String nom){
        if(nom != null){
            this.nom = nom;
        }
    }

    
    /** 
     * @return String
     */
    public String getNom(){
        return this.nom;
    }

    
    /** 
     * @return int
     */
    public int getNbMatiere(){
        int nbMatiere = 0;

        nbMatiere = this.bulletin.length;

        return(nbMatiere);
    }

    
    /** 
    * @param indiceMatiere
    * @param indiceNote
    * @return double
    */
    public double getUneNote(int indiceMatiere, int indiceNote){
        double noteToReturn = 0;

        if(indiceMatiere >= 0 && indiceMatiere < this.bulletin.length){
            if(indiceNote > 0 && indiceNote < this.bulletin[indiceMatiere].length){
                noteToReturn = this.bulletin[indiceMatiere][indiceNote];
            }
        } else {
            System.out.println("getUneNote : Erreur");
        }

        return(noteToReturn);
    }
    
    
    /** 
     * @return String
     */
    public String meilleurNote() {
        double meilleureNote = 0;  
        String matiereMeilleureNote = "";
    
        for (int i = 0; i < this.bulletin.length; i++) {
            for (int j = 0; j < this.bulletin[i].length; j++) {
                if (this.bulletin[i][j] > meilleureNote) {
                    meilleureNote = this.bulletin[i][j];
                    matiereMeilleureNote = this.MATIERES[i];
                }
            }
        }
        
        return(matiereMeilleureNote + " " + meilleureNote);
    }
    
    public String toString() {
        String result = "Nom de l'etudiant: " + this.nom + "\n";

        for (int i = 0; i < this.MATIERES.length; i++) {
            result += "Matiere: " + this.MATIERES[i] + "\n";
            result += "Notes: ";
            for (int j = 0; j < this.bulletin[i].length; j++) {
                result += this.bulletin[i][j] + " ";
            }
            result += "\n";
            result += "Moyenne: " + moyenneMatiere(i) + "\n\n";  // Ajout d'une ligne vide entre chaque matière
        }

        result += "Moyenne generale: " + moyenneGenerale() + "\n";

        return result;
    }

    private void initialisation(){
        for(int i = 0; i < this.bulletin.length; i++){
            for(int j = 0; j < this.bulletin[i].length; j++){
                this.bulletin[i][j] = (Math.random())*20;
            }
        }
    }

    public double moyenneMatiere(int indiceMatiere){
        double sommeNote = 0;
        double moyenneNote = 0;
        if(indiceMatiere > this.bulletin.length || indiceMatiere < 0){
            System.out.println("moyenneMatiere : Erreur indice");
        } else {
            for(int i = 0; i < this.bulletin[indiceMatiere].length; i++){
                sommeNote += this.bulletin[indiceMatiere][i];
            }
        }
        moyenneNote = sommeNote/this.bulletin[indiceMatiere].length;
        return (moyenneNote);
    }

    public double moyenneGenerale() {
        double somme = 0;
        double sommeCoeff = 0;
        double resultat = 0;
    
        if (this.bulletin.length != 0) {
            for (int i = 0; i < this.bulletin.length; i++) {
                double moyenneMatiere = moyenneMatiere(i);  // Utilise la méthode moyenneMatiere ici
                somme += moyenneMatiere * this.COEFFICIANTS[i];
            }
    
            for (int j = 0; j < this.COEFFICIANTS.length; j++) {
                sommeCoeff += this.COEFFICIANTS[j];
            }
    
            resultat = somme / sommeCoeff;
        } else {
            System.out.println("Etudiant pas note !");
        }
        return resultat;
    }
    
    public void bulletinEtudiant() {
        System.out.println("Bulletin de l'etudiant: " + this.nom);

        for (int i = 0; i < this.MATIERES.length; i++) {
            double moyenneMatiere = moyenneMatiere(i);
            System.out.println(this.MATIERES[i] + ": " + moyenneMatiere);
        }

        double moyenneGenerale = moyenneGenerale();
        System.out.println("Moyenne generale: " + moyenneGenerale);
        System.out.println("\n\n");
    }
}
