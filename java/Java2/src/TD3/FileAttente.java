package TD3;

import java.util.ArrayList;

public class FileAttente <T>
{
    private String nomFile;
    private static int nbEntreesTotal = 0;
    private ArrayList<T> contenu;
    public FileAttente(){contenu=new ArrayList<T>();}
    public void entre(T p){contenu.add(p); nbEntreesTotal++;}
    public T sort()
    {
        T p=null;
        if (!contenu.isEmpty())
        {p=contenu.get(0);
            contenu.remove(0);}
        return p;
    }
    public int nbElements(){return contenu.size();}
    public boolean estVide(){return contenu.isEmpty();}
    public String toString(){return ""+descriptionContenu();}
    private String descriptionContenu()
    {
        String resultat = "";
        for (T p:this.contenu)
            resultat += p + " ";
        return resultat;
    }
    public int getNbEntreesTotal(){
        return nbEntreesTotal;
    }
    public static<T,E> boolean comparaison(FileAttente<T> FA1, FileAttente<E> FA2){//forte chance que ce sois pas ça, plus comme memeListe
        if(!(FA1.contenu.isEmpty()) || !(FA2.contenu.isEmpty())){
            return FA1.contenu.get(0).getClass()==FA2.contenu.get(0).getClass();
        }
        return false;
    }
    public boolean memeListe(FileAttente<T> FA1){
        return this.contenu.equals(FA1.contenu);
    }
    public boolean memeTaille(FileAttente<T> FA1){
        return this.contenu.size() == FA1.contenu.size();
    }
}
