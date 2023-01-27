package TD2;

public interface CompteDepot extends CompteRemunere{
    default void fermetureCB() {
        ModifierSolde(informationCB()-100);

    }
}
