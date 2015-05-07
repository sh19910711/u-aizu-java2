import java.util.Arrays;
public class TryMenSort {
  public static void main(String[] args) {
    SortableMen[] srtm = {
      new SortableMen("Man D",25),
      new SortableMen("Man A",25),
      new SortableMen("Man A",30),
      new SortableMen("Man B",25)
		      };

    System.out.println("Original Order: ");
    for (SortableMen m : srtm) System.out.println(m);

    Arrays.sort(srtm);

    System.out.println("\nOrder after sorting using Comparable method: ");
    for (SortableMen m : srtm) System.out.println(m);
 }

}
