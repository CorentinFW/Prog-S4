package TD3.rayon;

public class Produit implements ObjetAvecEtiquette{
    private String etique;
    public Produit(String etique){
        this.etique=etique;
    }
    public String etiquette(){
        return this.etique;
    }

    public String getEtiquette() {
        return etique;
    }
}
