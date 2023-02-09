package TD3.rayon;

import java.util.ArrayList;

public class Rayon<T>{
    private ArrayList<T> contenu=new ArrayList<T>();
    public Rayon(){
        contenu = new ArrayList<T>();
    }
    public String listingContenu()
    {

        String listing="";
        for (T c:contenu)
            listing += c.etiquette();
        return listing;
    }

    public void ajoutsiabsent(T A){
        if(!(contenu.contains(A))){
            contenu.add(A);
        }
    }


    public ArrayList<T> getContenu() {
        return contenu;
    }
}
