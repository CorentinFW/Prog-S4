package TD1;
import java.util.ArrayList;
public class Pile implements IPile{
    // structure de stockage interne des  ́el ́ements
    private ArrayList<Object> elements;
    // Mise en oeuvre des op ́erations
    public Pile(){initialiser();}
    public Object depiler() throws PileVideException{
        if (this.estVide())
            throw new PileVideException("en d ́epilant");
        Object sommet = elements.get(elements.size()-1);
        int oldtaille = elements.size() ;
        elements.remove(sommet);
        assert (oldtaille== elements.size()+1) ;
        return sommet;
    }
    public void empiler(Object t) throws PileVideException {
        int oldelement = elements.size();
        elements.add(t);
        assert this.sommet()==t : "dernier empile ="+this.sommet();
    }
    public boolean estVide() {return elements.isEmpty();}
    public void initialiser() {
        elements = new ArrayList<Object>();
        assert elements.size()==0;
        }
    public Object sommet() throws PileVideException{
        if (this.estVide())
            throw new PileVideException("en d ́epilant");
        return elements.get(elements.size()-1);
    }
    public int taille(){return elements.size();}
    public String toString(){return "Pile = "+ elements;}
}
/*Question 3 On desire creer un nouveau type de pile, representant les piles born´ees, c’est-
        a-dire des piles dont le nombre d’elements doit rester inf´erieur `a une certaine limite (taille
        maximale). Cette taille maximale peut ´evoluer pendant la vie de la pile.
        — Proposez une description du type abstrait (en indiquant en quoi il diff`ere du type
        pile).
        une limite constant pour la taille de la pile, et bcp d'exception en plus
        — Ecrivez les classes d’exceptions repr´esentant les erreurs qui peuvent se produire sur
        les piles born´ees : la pile est pleine et on ne peut plus ajouter d’´el´ements ; la taille
        maximale ne peut pas ˆetre n´egative ; la taille maximale est diminu´ee mais le nombre
        d’´el´ements d´ej`a stock´es est sup´erieur `a cette nouvelle taille maximale.
        — Proposez une interface pour repr´esenter le type Pile born´ee.
        — Proposez une classe pour l’impl´ementer. Les m´ethodes comporteront des assertions
        et des signalements d’exceptions aux endroits n´ecessaires. Par d´efaut, la taille maximale est de 10 ´el´ements.
        — Ecrivez un programme utilisant cette classe. Est-ce qu’une pile bornee peut remplacer une pile : lors de la compilation (substituabilite syntaxique) ? lors de l’execution
        (substituabilite comportementale) ?*/