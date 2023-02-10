package TD3.rayon;

public class ManRayon {
    public static void main(String[] args) {
        Rayon carrefour = new Rayon();
        Livres ldveh = new Livres("acion");
        Livres jv = new Livres("actions");
        Livres WWII = new Livres("histoires");
        Produit sopalin = new Produit("wc");
        carrefour.ajoutsiabsent(ldveh);
        carrefour.ajoutsiabsent(jv);
        carrefour.ajoutsiabsent(WWII);
        System.out.println(carrefour.listingContenu());
        carrefour.ajoutsiabsent(sopalin);
        System.out.println(carrefour.listingContenu());
    }
}
