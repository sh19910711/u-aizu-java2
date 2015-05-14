// In program "TryRecordSort.java", an array of SortableRecord objects is sorted.
// Check TryRecordSort.java to see how SortableRecord is used.
import java.util.ArrayList;
import java.util.Arrays;

public class OldTryRecordSort {
  public static void main(String[] args) {
    ArrayList<SortableRecord> list = new ArrayList<SortableRecord>();
    list.add(new SortableRecord("s5000001", 90, 85, 60));
    list.add(new SortableRecord("s5000002", 50, 75, 85));
    list.add(new SortableRecord("s5000003", 85, 65, 75));
    list.add(new SortableRecord("s5000004", 75, 80, 90));
    list.add(new SortableRecord("s5000005", 60, 64, 100));
    list.add(new SortableRecord("s5000006", 80, 75, 80));
    list.add(new SortableRecord("s5000007", 95, 67, 70));

    System.out.println("TryRecordSort");
    System.out.println(list.size());

    // Output original order
    System.out.println("Original Order: ");
    for ( Record r : list ) {
      System.out.println(r.toString());
    }

  }
}
