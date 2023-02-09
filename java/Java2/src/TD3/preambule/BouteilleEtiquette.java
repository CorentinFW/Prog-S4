package TD3.preambule;

public class BouteilleEtiquette <A,B>{
    private A bouteille;
    private B etiquette;
    public BouteilleEtiquette(A bouteille,B etiquette){
        this.bouteille=bouteille;
        this.etiquette=etiquette;
    }

    public void setBouteille(A bouteille) {
        this.bouteille = bouteille;
    }

    public void setEtiquette(B etiquette) {
        this.etiquette = etiquette;
    }

    public A getBouteille() {
        return bouteille;
    }

    public B getEtiquette() {
        return etiquette;
    }
}
