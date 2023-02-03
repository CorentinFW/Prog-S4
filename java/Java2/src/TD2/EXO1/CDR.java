package TD2.EXO1;

public class CDR implements CompteDepotRemunere{
    private double solde;
    public CDR(double solde){
        this.solde=solde;
    }
    @Override
    public double informationCB() {
        return solde;
    }

    @Override
    public void ModifierSolde(double n) {
        solde = n;

    }
}
