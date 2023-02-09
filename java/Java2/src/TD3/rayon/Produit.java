package TD3.rayon;

public class Produit implements ObjetAvecEtiquette{
    private String etiquette;
    public Produit(String etiquette){
        this.etiquette=etiquette();
    }
    public String etiquette(){
        return etiquette;
    }

    public String getEtiquette() {
        return etiquette;
    }
}
