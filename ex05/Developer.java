// Create a new annotation type: "Developer".
// It contains only one attribute: "developer_name", which is an annotation type called "Name".
// The annotation type: "Name" contains two attributes of
// type "String": "first_name" and "last_name". 
// The annotation "Developer" is available at runtime and for classes only.

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Developer {
  public Name developer_name();
}

