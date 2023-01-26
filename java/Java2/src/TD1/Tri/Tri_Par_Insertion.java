package TD1.Tri;
import java.util.Arrays;


public class Tri_Par_Insertion {
    public static void triInsertion(int tableau[]) {
        int taille = tableau.length;
// Pour chaque ´el´ement du tableau
        for (int i = 1; i < taille; i++){
            int index = tableau[i];
// On cherche sa place entre 0 et i-1
// on d´ecale vers la droite les ´el´ements qui le pr´ec`edent
// dans le tableau mais sont plus grand que lui
            int j = i-1;
            while(j >= 0 && tableau[j] > index) {
                tableau[j+1] = tableau[j];
                j--;
            }
// puis on le positionne
            tableau[j+1] = index;
            System.out.println("Etat du tableau `a l’´etape "+ i);
            System.out.println(Arrays.toString(tableau));
        }
    }
    public static void main(String str[]){
        int[] tab = {2,13,14,3,5,4,112,37,9,11,18,1};
        System.out.println("Etat du tableau avant le tri");
        System.out.println(Arrays.toString(tab));
//tri par insertion
        triInsertion(tab);
        System.out.println("Etat du tableau apr`es le tri");
        System.out.println(Arrays.toString(tab));
    }
}
