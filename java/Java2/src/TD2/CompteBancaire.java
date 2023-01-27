package TD2;

public interface CompteBancaire {
    float informationCB();
    void ModifierSolde(double n);
    default void fermetureCB(){
       System.out.println("je ferme mon compte et j'avais :"+informationCB()+"euro");
    }
}
