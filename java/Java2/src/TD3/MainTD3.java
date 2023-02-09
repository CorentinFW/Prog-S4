package TD3;

import TD3.preambule.FileAttente;
import TD3.preambule.Personne;
import TD3.preambule.Rectangle;

public class MainTD3 {
    public static void main(String[] args) {
        FileAttente<Personne> FP = new FileAttente<Personne>();
        FP.entre(new Personne("filipe","ph"));
        FP.entre(new Personne("mathieu","ortega"));
        FileAttente<Rectangle> RP = new FileAttente<>();
        RP.entre(new Rectangle(10,40));
        FileAttente FP2 = new FileAttente<Personne>();
        FP2.entre(new Personne("réynier","theo"));
        System.out.println(FP);
        System.out.println(FP.memeTaille(FP2));
    }
}
