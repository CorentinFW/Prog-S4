package TD3.preambule;

public class PaireHomogene <A>{
    private A first;
    private A second;
    public PaireHomogene(A first,A second){
        this.first=first;
        this.second=second;
    }

    public A getFirst() {
        return first;
    }

    public A getSecond() {
        return second;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(A second) {
        this.second = second;
    }
}
