package TD3.rayon;

import java.util.ArrayList;

public class Rayon{
    private ArrayList<Produit> contenu=new ArrayList<Produit>();
    public Rayon(){
        contenu = new ArrayList<Produit>();
    }
    public String listingContenu()
    {

        String listing="";
        for (Produit c:contenu)
            listing += c.etiquette();
        return listing;
    }

    public void ajoutsiabsent(Produit A){
        if(!(contenu.contains(A))){
            contenu.add(A);
        }
    }


    public ArrayList<Produit> getContenu() {
        return contenu;
    }
}
