package TD2;

public interface CompteRemunere extends CompteBancaire {



    default void fermetureCB() {
       ModifierSolde(informationCB()*1.10);
        CompteBancaire.super.fermetureCB();

    }
}
