package TD4;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class maincreateI {
    public static void main(String[] args) {
        Class classe = Appartement.class;
        Class[] interfaces = Appartement.class.getInterfaces();
        Method[] meth = Appartement.class.getMethods();
        System.out.print("public interface I"+classe.getName() +" extends I"+classe.getSuperclass().getSimpleName());
        int j=0;
        for(Class i : interfaces){
            if(j<interfaces.length-1){
                System.out.print(","+i.getSimpleName());
            }
            else {
                System.out.print(","+i.getSimpleName());
            }
            j++;
        }
        System.out.println("{");
        for(Method m : meth){
            Parameter[] params = m.getParameters();
            System.out.print("   "+m.getReturnType().getSimpleName()+" "+m.getName()+"(");
            for(Parameter p : params){
                System.out.print(p.getType().getSimpleName()+" p");
            }
            System.out.println(");");
        }
        System.out.println("}");



    }





}
