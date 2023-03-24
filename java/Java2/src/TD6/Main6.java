package TD6;

public class Main6 {
    public static void main(String[] args) {
        ADB origine = new ADB_E();
        ADB ligneUn = new ADB_E();
        ADB ligneDeuxUn = new ADB_E();
        ADB ligneDeuxDeux = new ADB_E();
        ADB feuille1 = new Feuille("yes");
        ADB feuille2 = new Feuille("no");
        ADB feuille3 = new Feuille("dbs");
        ADB feuille4 = new Feuille("kh");
        ADB feuille0 = new Feuille("end");
        ligneDeuxUn.composer("binaire",feuille1,feuille2);
        ligneDeuxDeux.composer("boucle du moment",feuille3,feuille4);
        ligneUn.composer("test",ligneDeuxUn,ligneDeuxDeux);
        System.out.println(origine.composer("tu a la ref",ligneUn,feuille0));
        ADB vertébré = new ADB_E();
        ADB plumes = new ADB_E();
        ADB poils = new ADB_E();
        ADB coquille = new ADB_E();
        ADB oiseau = new Feuille("oiseau");
        ADB poisson_ou_reptile = new Feuille("poisson_ou_reptile");
        ADB mammifère = new Feuille("mammifère");
        ADB arthropode = new Feuille("arthropode");
        ADB mollusque = new Feuille("mollusque");


    }
}
