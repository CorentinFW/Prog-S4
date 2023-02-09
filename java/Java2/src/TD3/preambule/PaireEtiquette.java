package TD3.preambule;

import java.lang.reflect.Type;

public class PaireEtiquette<A,B> {
    private A typeA;
    private B typeB;
    public PaireEtiquette(A typeA, B TypeB){
        this.typeA=typeA;
        this.typeB=typeB;
    }

    public A getTypeA() {
        return typeA;
    }

    public B getTypeB() {
        return typeB;
    }

    public void setTypeA(A typeA) {
        this.typeA = typeA;
    }

    public void setTypeB(B typeB) {
        this.typeB = typeB;
    }
}
