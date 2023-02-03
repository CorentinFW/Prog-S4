package TD2.EXO5;

public class Beer{
    public double beerEBC() {return 2.939*Math.pow(MCU(), 0.6859);}
    public double MCU() {
        if (this instanceof SingleMaltBeer){
            SingleMaltBeer smb = (SingleMaltBeer)this;
            return 4.23*smb.getMaltEBC()*
                    smb.getMaltWeight()/smb.getBeerVolume();
        } else return 1;
    }
}