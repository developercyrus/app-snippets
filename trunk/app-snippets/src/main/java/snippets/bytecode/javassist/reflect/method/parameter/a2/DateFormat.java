package snippets.bytecode.javassist.reflect.method.parameter.a2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)  

public @interface DateFormat {  
    String value() default "yyyy-MM-dd";  
}  