import java.util.Comparator;
import java.util.Arrays;
/**
 * Sort using merge sort.
 *
 * @author Kevin Fitzgerald
 * @author Rene Urias
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  public <T> void sort(T[] vals,Comparator<? super T> comparator) {
    int lo = 0;
    int hi = vals.length;
    sorthelper(vals, lo, hi, comparator);
  } // sort

/**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void sorthelper(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    if (hi - lo < 2) {
    } //end recursion when each is one term
    else{
     int mid = lo + (hi - lo) / 2;
     sorthelper(vals, lo, mid,comparator);
     sorthelper(vals, mid, hi, comparator);
     merge(vals, lo, mid, hi, comparator);
    }//if it still needs to recurse
   } // sort


  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int leftIndex = lo, rightIndex = mid;
      T[] leftArray = Arrays.copyOfRange(vals, lo, mid);
      T[] rightArray = Arrays.copyOfRange(vals, mid, hi);
    for (int i = lo; i < hi; i++)
    {
      if (leftIndex >= mid && rightIndex < hi){
        vals[i] = rightArray[rightIndex - mid];
        rightIndex++;
        }//if left is done
      else if (leftIndex < mid && rightIndex >= hi){
          vals[i] = leftArray[leftIndex - lo];
          leftIndex++;
        }//if right is done
      else if (rightIndex < hi){
          int bool = comparator.compare(leftArray[leftIndex - lo],rightArray[rightIndex - mid]);
          if(bool <= 0){
            vals[i] = leftArray[leftIndex - lo];
            leftIndex++;
          } // if right is greater
          else if (bool > 0 ){
            vals[i] = rightArray[rightIndex - mid];
            rightIndex++;
          } // if right is greater
    }// if both have vals and rightindex isnt done
  }// for
  } // merge

}//MergeSort
