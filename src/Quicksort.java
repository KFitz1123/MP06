import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Kevin Fitzgerald
 * @author Jonathan Wang
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */ 

  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  private static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
    System.out.println("\n");
    for(int i = 0; i < arr.length - 1; i++){
    System.out.print(arr[i] + ",");
    System.out.flush();
  }
  System.out.print(arr[arr.length - 1] + "}\n");
  System.out.flush();
    System.out.println("loop " + lb + " " + ub);
    T pivotVal = (arr[(ub + lb) / 2]);
    T temp = arr[lb];
    arr[lb] = pivotVal;
    arr[(ub + lb) / 2] = temp;
    int small = lb + 1;
    int large = ub - 1;

    while (small <= large){
      int comp = compare.compare(pivotVal, arr[small]);
      if(comp >= 0){
        small++;
      }
      if(comp < 0){
        temp = arr[small];
        arr[small] = arr[large];
        arr[large] = temp;
        large--;
      }
    }
    temp = arr[lb];
    arr[lb] = arr[small - 1];
    arr[small - 1] = temp;

    return small - 1;
  }

  /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   */
 static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } else {
      int mid = partition(values, order, lb, ub);
      quicksort(values, order, lb, mid);
      quicksort(values, order, mid+1, ub);
    } // if/else
  } // quicksort(T[], Comparator, int, int)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>
} // class Quicksort
