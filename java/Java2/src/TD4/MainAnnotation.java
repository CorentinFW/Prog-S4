package TD4;

import java.lang.annotation.Annotation;
import java.lang.annotation.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MainAnnotation {
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args) {
        Class perso = Personne.class;
        Method[] method = Personne.class.getMethods();
        Field[] attribut = Personne.class.getFields();

        List<Annotation> annotationsClass = Arrays.asList(perso.getAnnotationsByType(Refactoring.class));
        if(!annotationsClass.isEmpty()){
            System.out.println(perso.getSimpleName()+" : "+ ( (Refactoring) annotationsClass.get(0)).commentaire());
        }
        for(Field f: attribut){
            List<Annotation> annotationsF = Arrays.asList(f.getAnnotationsByType(Refactoring.class));
            if (!annotationsF.isEmpty()){
                System.out.println(f.getName()+" : "+((Refactoring) annotationsF.get(0)).commentaire());
            }
        }
        for(Method m: method){
            List<Annotation> annotationsM = Arrays.asList(m.getAnnotationsByType(Refactoring.class));
            if (!annotationsM.isEmpty()){
                System.out.println(m.getName()+" : "+((Refactoring) annotationsM.get(0)).commentaire());
            }
        }

    }
}
