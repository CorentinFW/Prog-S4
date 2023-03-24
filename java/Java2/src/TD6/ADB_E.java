package TD6;

public class ADB_E<E> implements ADB{
    private E etiquette;
    private ADB gauche;
    private ADB droite ;
    @Override
    public ADB composer(Object etiquette, ADB vrai, ADB faux) {
        this.etiquette = (E)etiquette;
        this.gauche = vrai;
        this.droite = faux;
        return this;
    }

    @Override
    public ADB sousArbreGauche() {
        return gauche;
    }

    @Override
    public ADB sousArbreDroite() {
        return droite;
    }

    @Override
    public boolean estVide() {
        if(this.gauche == null && this.droite == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean estFeuille() {
        return false;
    }

    @Override
    public E getEtiquette() {
        return this.etiquette;
    }

    @Override
    public String toString(){
        return this.getEtiquette()+"("+ this.sousArbreGauche() +","+ this.sousArbreDroite() + ")";
    }
}
