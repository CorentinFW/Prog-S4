package TD3.file_attente;

public class ManFA {
    public static void main(String[] args) {
        //FileAttente2<Personne> fp = new FileAttente2<Adulte>(); //pas le droit
        //FileAttente2<Adulte> fa = new FileAttente2<Personne>(); //pas le droit
        FileAttente2 FPersonne = new FileAttente2<Personne>();
        FileAttente2 FAdulte = new FileAttente2<Adulte>();
        FileAttente2 FEnfant = new FileAttente2<Enfant>();
    }
}
