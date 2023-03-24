package TD6;

public interface ADB<E> {
    public ADB<E> composer(Object etiquette, ADB vrai, ADB faux);
    public ADB sousArbreGauche();


    public ADB sousArbreDroite();


    public boolean estVide();


    public boolean estFeuille();
    public E getEtiquette();
    String toString();
}
