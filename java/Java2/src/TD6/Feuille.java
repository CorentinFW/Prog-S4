package TD6;

public class Feuille<E> implements ADB{
    private E etiquette;
    public Feuille(E etiquette){
        this.etiquette = etiquette;
    }
    @Override
    public ADB<E> composer(Object etiquette, ADB vrai, ADB faux) {

        System.out.println("pas possible car c'est une feuille !!!!!!!!!");
        return null;
    }

    @Override
    public ADB sousArbreGauche() {
        System.out.println("pas possible car c'est une feuille !!!!!!!!!");
        return null;
    }

    @Override
    public ADB sousArbreDroite() {
        System.out.println("pas possible car c'est une feuille !!!!!!!!!");
        return null;
    }

    @Override
    public boolean estVide() {
        return false;
    }

    @Override
    public boolean estFeuille() {
        return true;
    }

    @Override
    public E getEtiquette() {
        return etiquette;
    }
    @Override
    public String toString(){
        return (String) etiquette;
    }
}
