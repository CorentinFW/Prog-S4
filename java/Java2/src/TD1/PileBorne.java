package TD1;

public interface PileBorne {
    void initialiser();
    void empiler(Object t) throws PileVideException;
    Object depiler()throws PileVideException;;
    Object sommet() throws PileVideException;
    boolean estVide();
    int taille();
    void augmentertaille();
}
