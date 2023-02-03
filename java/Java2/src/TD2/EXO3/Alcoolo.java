package TD2.EXO3;

public class Alcoolo {
    public static void main(String[] args) {
        System.out.println("main 1 = ");
        Biere biere1 = new Biere();
        biere1.description(); // main1
        System.out.println("main 2 = ");
        Biere biere2 = new Lambic();
        biere2.description(); // main2
        System.out.println("main 3 = ");
        Biere biereA1 = new MortSubiteKriek();
        biereA1.description(); // main3
        System.out.println("main 4 = ");
        BiereAcidulee biereA2 = new MortSubiteKriek();
        biereA2.description(); // main4
        System.out.println("main 5 = ");
        MortSubiteKriek biereA3 = new MortSubiteKriek();
        biereA3.description();// main5
        //comme c'est une suite d'heritier appeler le niveau du dessus en statique
        //mais l'héritier en dynamique en dessous alors cela revient a appeler et proc les dynamiques
    }
}
/*
1) a priori static c'est le class var, et le dynamique c'est le new class
2)MortSubiteKrieg rappelle couleur de sa mere donc il n’utilise jamais le sien

*/
