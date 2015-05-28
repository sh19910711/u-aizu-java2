import java.lang.annotation.*;

public @interface Name {
  public String first_name() default "";
  public String last_name() default "";
}

