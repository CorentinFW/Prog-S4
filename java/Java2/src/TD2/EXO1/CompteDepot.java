package TD2.EXO1;

public interface CompteDepot extends CompteBancaire{
    default void fermetureCB() {

        ModifierSolde(informationCB()-100);


    }
}
