package TD3.preambule;

import java.util.Date;

public class EntreeAgenda <A extends Date,B>{
    private A _date_;
    private B entree;
    public EntreeAgenda(A _date_,B entree){
        this.entree=entree;
        this._date_=_date_;
    }

    public void set_date_(A _date_) {
        this._date_ = _date_;
    }

    public void setEntree(B entree) {
        this.entree = entree;
    }

    public B getEntree() {
        return entree;
    }

    public A get_date_() {
        return _date_;
    }

    @Override
    public String toString() {
        return "EntreeAgenda{" +
                "_date_=" + _date_ +
                ", entree=" + entree +
                '}';
    }
}
