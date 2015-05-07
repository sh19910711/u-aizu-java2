// Create the "SortableRecord" class (SortableRecord.java)
// which extends the Record class and is sortable by implementing the Comparableinterface.
// Its "compareTo" method compares itself and another SortableRecord object
// in order of its superclass's attributes "score_total", "score_math", "score_Japanese" and "score_English".
import java.util.Collection;

public class SortableRecord extends Record implements Comparable<Record> {

  public SortableRecord(String id, int m, int j, int e) {
    super(id, m, j, e);
  }

  // Its "compareTo" method compares itself and another SortableRecord object
  // in order of its superclass's attributes
  //  - "score_total"
  //  - "score_math"
  //  - "score_Japanese"
  //  - "score_English".
  public int compareTo(Record r) {
    if ( score_total < r.score_total ) {
      return 1;
    } else if ( score_total > r.score_total ) {
      return -1;
    }

    if ( score_math < r.score_math ) {
      return 1;
    } else if ( score_math > r.score_math ) {
      return -1;
    }

    if ( score_Japanese < r.score_Japanese ) {
      return 1;
    } else if ( score_Japanese > r.score_Japanese ) {
      return -1;
    }

    if ( score_English < r.score_English ) {
      return 1;
    } else if ( score_Japanese > r.score_English ) {
      return -1;
    }
    
    return 0;
  }

}

