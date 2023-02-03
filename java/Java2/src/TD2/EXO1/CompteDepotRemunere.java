package TD2.EXO1;

public interface CompteDepotRemunere extends CompteDepot,CompteRemunere {
    default void fermetureCB(){
    CompteDepot.super.fermetureCB();
    CompteRemunere.super.fermetureCB();
    }
}
