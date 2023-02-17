package TD4;
import java.lang.annotation.*;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Repeatable(Refactorings.class)
public @interface Refactoring {

    String nom() default "[unsigned]";
    RefactoringName refact();
    String commentaire() default "[unsigned]";
    boolean dans_eclipse();
    int nbr_use();


}
