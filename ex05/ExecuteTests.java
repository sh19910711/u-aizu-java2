// Create a program: "ExecuteTests",
// which takes as input the name of a java class file,
// loads it, print the information for the "Developer" of this class
// and run the "Test" cases in it. 
import java.lang.reflect.*;
import java.util.*;

public class ExecuteTests {
  public static void main(String[] args) {
    Class type = null;
    try {
      type = Class.forName(args[0]);
    } catch(ClassNotFoundException e) {
      System.err.println(e);
      return;
    }

    // get developer name
    Developer developer = (Developer)type.getAnnotation(Developer.class);
    System.out.printf("Class developer: %s %s\n", developer.developer_name().first_name(), developer.developer_name().last_name());

    // run tests
    for ( Method method : type.getDeclaredMethods() ) {
      if ( ! method.isAnnotationPresent(Test.class) ) {
        continue;
      }

      Test test = (Test)method.getAnnotation(Test.class);
      if ( test.enabled() ) {
        boolean ret = true;
        try {
          method.invoke(null);
        } catch ( Throwable e ) {
          ret = false;
        } 
        if ( ret ) {
          System.out.printf("Test: %s succeed\n", method.getName());
        } else {
          System.out.printf("Test: %s failed\n", method.getName());
        }
      } else {
        System.out.printf("Test: %s ignored\n", method.getName());
      }
    }
  }
}

