package immutable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // This annotation will be available at runtime.
@Target(ElementType.METHOD)
public @interface AutoValidation {
}
