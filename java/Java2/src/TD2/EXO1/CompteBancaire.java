package TD2.EXO1;

public interface CompteBancaire {
    double informationCB();
    void ModifierSolde(double n);
    default void fermetureCB(){
       System.out.println("je ferme mon compte et j'avais :"+informationCB()+"euro");
    }
}
