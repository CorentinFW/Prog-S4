package TD1;

public interface PileBorne {
    void initialiser();
    void empiler(Object t) throws PileVideException,PileSurcharge;
    Object depiler()throws PileVideException,PileSurcharge;;
    Object sommet() throws PileVideException,PileSurcharge;
    boolean estVide();
    int taille();
    void augmentertaille();
}
