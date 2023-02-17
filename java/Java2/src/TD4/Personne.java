package TD4;
@Refactoring(nom = "Corentin",refact = RefactoringName.rename,commentaire="enleve les majuscule des attributs",dans_eclipse = true,nbr_use = 0)
public class Personne {

    public Personne (String nom,int age,int numrue,String nomrue,
                     String ville,int codepostale)
    {

        this.NomComplet = nom ;
        this.Age = age ;
        this.NumRue = numrue ;
        this.NomRue = nomrue ;
        this.Ville = ville ;
        this.CodePostale = codepostale ;
    }

    @Refactoring(nom = "Corentin",refact = RefactoringName.rename,commentaire="enleve les majuscule des attributs",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.encapsulatedField,commentaire="met les attributs en privée",dans_eclipse = true,nbr_use = 0)

    public String NomComplet ;
    @Refactoring(nom = "Corentin",refact = RefactoringName.rename,commentaire="enleve les majuscule des attributs",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.encapsulatedField,commentaire="met les attributs en privée",dans_eclipse = true,nbr_use = 0)

    public int Age ;
    @Refactoring(nom = "Corentin",refact = RefactoringName.rename,commentaire="enleve les majuscule des attributs",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.encapsulatedField,commentaire="met les attributs en privée",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.extractClass,commentaire="extraire vers adresse",dans_eclipse = true,nbr_use = 0)

    public int NumRue ;
    @Refactoring(nom = "Corentin",refact = RefactoringName.rename,commentaire="enleve les majuscule des attributs",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.encapsulatedField,commentaire="met les attributs en privée",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.extractClass,commentaire="extraire vers adresse",dans_eclipse = true,nbr_use = 0)
    public String NomRue ;
    @Refactoring(nom = "Corentin",refact = RefactoringName.rename,commentaire="enleve les majuscule des attributs",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.encapsulatedField,commentaire="met les attributs en privée",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.extractClass,commentaire="extraire vers adresse",dans_eclipse = true,nbr_use = 0)

    public String Ville ;
    @Refactoring(nom = "Corentin",refact = RefactoringName.rename,commentaire="enleve les majuscule des attributs",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.encapsulatedField,commentaire="met les attributs en privée",dans_eclipse = true,nbr_use = 0)
    @Refactoring(nom = "Corentin",refact = RefactoringName.extractClass,commentaire="extraire vers adresse",dans_eclipse = true,nbr_use = 0)
    public int CodePostale ;

    @Refactoring(nom = "Corentin",refact = RefactoringName.extractMethod,commentaire="pour extraireune adresse",dans_eclipse = true,nbr_use = 0)

    public void AfficherAdresse()
    {

        System.out.println("Numero de rue : "+NumRue);
        System.out.println("Nom de la rue : "+NomRue);
        System.out.println("Nom de la ville : "+Ville);
        System.out.println("CodePostale : "+CodePostale);
    }
}
