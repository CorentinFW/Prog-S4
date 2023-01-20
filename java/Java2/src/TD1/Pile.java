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

        elements.remove(sommet);
        return sommet;
    }
    public void empiler(Object t) throws PileVideException {
        elements.add(t);
        assert this.sommet()==t : "dernier empile ="+this.sommet();
    }
    public boolean estVide() {return elements.isEmpty();}
    public void initialiser() {
        elements = new ArrayList<Object>();
        }
    public Object sommet() throws PileVideException{
        if (this.estVide())
            throw new PileVideException("en d ́epilant");
        return elements.get(elements.size()-1);
    }
    public int taille(){return elements.size();}
    public String toString(){return "Pile = "+ elements;}
}
