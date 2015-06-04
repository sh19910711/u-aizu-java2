// Create a new annotation type: "Test".
// It contains only one "boolean" attribute: "enabled", which defaults to "true".
// This annotation should be available at runtime and for methods only.

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
  public boolean enabled() default true;
}

