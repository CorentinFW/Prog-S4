package TD5;

import java.util.ArrayList;
import java.util.Iterator;

public class DirectionLycee {
    private EmployeLycee proviseur, proviseurAdjoint, conseillerPrincipaldEducation, gestionnaire, chefDeTravaux;
    public DirectionLycee() {}
    public EmployeLycee getProviseur() {return proviseur;}
    public void setProviseur(EmployeLycee proviseur) {this.proviseur = proviseur;}
    public EmployeLycee getProviseurAdjoint() {return proviseurAdjoint;}
    public void setProviseurAdjoint(EmployeLycee proviseurAdjoint)
    {this.proviseurAdjoint = proviseurAdjoint;}
    public EmployeLycee getConseillerPrincipaldEducation()
    {return conseillerPrincipaldEducation;}
    public void setConseillerPrincipaldEducation(EmployeLycee conseillerPrincipaldEducation)
    {this.conseillerPrincipaldEducation = conseillerPrincipaldEducation;}
    public EmployeLycee getGestionnaire() {return gestionnaire;}
    public void setGestionnaire(EmployeLycee gestionnaire) {this.gestionnaire = gestionnaire;}
    public EmployeLycee getChefDeTravaux() {return chefDeTravaux;}
    public void setChefDeTravaux(EmployeLycee chefDeTravaux)
    {this.chefDeTravaux = chefDeTravaux;}
    public String toString() {
        String res ="Direction du lycee "+"\nproviseur "+this.getProviseur()
                +"\nproviseur adjoint "+this.getProviseurAdjoint()
                +"\ngestionnaire "+this.getGestionnaire()
                +"\nCPE "+this.getConseillerPrincipaldEducation()
                +"\nChef de travaux "+this.getChefDeTravaux();
        return res;
    }
    public int ageMoyen() {
        return (this.getProviseur().getAge()+this.getProviseurAdjoint().getAge()+
                this.getConseillerPrincipaldEducation().getAge()+
                this.getGestionnaire().getAge()+
                this.getChefDeTravaux().getAge())/5;
    }
    public void afficherNoms(){
        System.out.println("Direction du lycee "+"\nproviseur : "+this.getProviseur().getNom()
                +"\nproviseur adjoint : "+this.getProviseurAdjoint().getNom()
                +"\ngestionnaire : "+this.getGestionnaire().getNom()
                +"\nCPE : "+this.getConseillerPrincipaldEducation().getNom()
                +"\nChef de travaux : "+this.getChefDeTravaux().getNom());
}

    public ArrayList<EmployeLycee> recruteApres(int years){
        ArrayList<EmployeLycee> listeE = new ArrayList<>();
        //listeE.add();
        if(this.getProviseur().getAnneeRecrutement()>years){
            listeE.add(this.getProviseur());
        }
        if(this.getProviseurAdjoint().getAnneeRecrutement()>years){
            listeE.add(this.getProviseurAdjoint());
        }
        if(this.getGestionnaire().getAnneeRecrutement()>years){
            listeE.add(this.getGestionnaire());
        }
        if(this.getConseillerPrincipaldEducation().getAnneeRecrutement()>years){
            listeE.add(this.getConseillerPrincipaldEducation());
        }
        if(this.getChefDeTravaux().getAnneeRecrutement()>years){
            listeE.add(this.getChefDeTravaux());
        }
        return listeE;
    }

    public double ageMoyenCategorieAvant(Categorie cat,int years){
        ArrayList<EmployeLycee> listeE = new ArrayList<>();
        //listeE.add();
        if(this.getProviseur().getAnneeRecrutement()<years&& this.getProviseur().getCategorie() == cat){
            listeE.add(this.getProviseur());
        }
        if(this.getProviseurAdjoint().getAnneeRecrutement()<years&& this.getProviseurAdjoint().getCategorie() == cat){
            listeE.add(this.getProviseurAdjoint());
        }
        if(this.getGestionnaire().getAnneeRecrutement()<years&& this.getGestionnaire().getCategorie() == cat){
            listeE.add(this.getGestionnaire());
        }
        if(this.getConseillerPrincipaldEducation().getAnneeRecrutement()<years&& this.getConseillerPrincipaldEducation().getCategorie() == cat){
            listeE.add(this.getConseillerPrincipaldEducation());
        }
        if(this.getChefDeTravaux().getAnneeRecrutement()<years && this.getChefDeTravaux().getCategorie() == cat){
            listeE.add(this.getChefDeTravaux());
        }
        int somme = 0;
        int diviseur = 0;
        for(EmployeLycee empl : listeE){
            somme+= empl.getAge();
            diviseur++;
        }
        return somme/diviseur;
    }

    /*
    int anneeRecrutementPlusAnciennePourCorps(String corps){}
     */
//si on ajoute un nouvelle attribut il faudra rajouter a la main dans les méthodes l'existence de cette attribut pour qu'il soit pris en compte

    

}
