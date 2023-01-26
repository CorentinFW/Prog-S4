package TD1.Pile;

public interface IPileBorne {
    void initialiser();
    void empiler(Object t) throws PileVideException,PileSurchargeException;
    Object depiler()throws PileVideException,PileTailleNegException;
    Object sommet() throws PileVideException,PileTailleNegException;
    boolean estVide() throws PileTailleNegException;
    int taille();
    void augmentertaille() throws PileBorneChangeException;
}
