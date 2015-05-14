import java.util.*;

public class ShortStrings implements Iterator<String> {
  private Iterator<String> strings ;  // source for strings
  private String nextShort;  // null if next not known
  private final int maxLen;  // only return strings <= 

  public ShortStrings(Iterator<String> strings, int maxLen) {
    this.strings = strings;
    this.maxLen = maxLen;
    nextShort = null;
  }

  public boolean hasNext() {
    if (nextShort != null)  // found it already
      return true;
    while (strings.hasNext()) {
      nextShort = strings.next();
      if (nextShort.length() <= maxLen) return true;
    }
    nextShort = null;   // did not find one
    return false;
  }

  public String next() {
    if (nextShort == null && !hasNext())
      throw new NoSuchElementException();
    String n = nextShort;  // remember nextShort
    nextShort = null;
    return n;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}


