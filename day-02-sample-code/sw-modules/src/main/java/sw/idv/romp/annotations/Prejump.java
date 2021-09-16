package sw.idv.romp.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Prejump {
    String value() default "";
    String name() default "";
}
