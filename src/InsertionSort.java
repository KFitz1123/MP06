import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Kevin Fitzgerald
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    T temp;
    for(int i = 0; i < values.length - 1; i++){
      int j = i + 1;
      while(order.compare(values[i], values[j]) > 0){
        temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        if (i > 0){
          i--;}
          else{
            i++;
          }
          j = i + 1;
      }//while i > j
    }//for
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
