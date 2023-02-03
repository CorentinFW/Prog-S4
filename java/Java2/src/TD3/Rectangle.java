package TD3;

public class Rectangle {
    private float largeur;
    private float longueur;
    public Rectangle(float largeur,float longueur){
        this.largeur = largeur;
        this.longueur = longueur;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "largeur=" + largeur +
                ", longueur=" + longueur +
                '}';
    }
}
