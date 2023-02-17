package TD4;

import java.lang.annotation.*;
import java.util.List;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
public @interface Refactorings {
    Refactoring[] value();
}
