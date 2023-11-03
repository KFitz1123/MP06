import java.util.Arrays;
import java.util.Comparator;
/**
 * Sort using a TimSort.
 *
 * @author Kevin Fitzgerald
 * @author ChatGPT
 */
public class FitzgeraldKevinSort implements Sorter{


 // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new FitzgeraldKevinSort();
  private static final int MIN_MERGE = 32;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
    

    public FitzgeraldKevinSort() {
        
    }

// +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
    public <T> void sort(T[] arr, Comparator<? super T > comparator) {
        int n = arr.length;

        for (int i = 0; i < n; i += MIN_MERGE) {
            int left = i;
            int right = Math.min(i + MIN_MERGE - 1, n - 1);
            insertionSort(arr,comparator,left, right);
        }

        for (int size = MIN_MERGE; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(arr,comparator,left, mid, right);
                }
            }
        }
    }

    private <T> void insertionSort(T[] arr,Comparator<? super T> comparator, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= left && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private <T> void merge(T[] arr,Comparator<? super T> comparator,int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        Comparator<Integer> intComparator = Integer::compare;
        new FitzgeraldKevinSort().sort(arr,intComparator);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

/*
 * I was honestly surprised that the sorting itself works. It was not, of course, able to connect it to the sorter.java interface, so there were a lot of 
 * changes I needed to make to make the sorting code actually run. It did save a lot of time to type the code itself, and it showed me that 
 * ChatGPT is a dangerous tool for people who are trying to learn. The muscle-memory and problem-solving that it would have taken to write the raw
 * code was skipped in less than ten seconds. As much as I appreciate the time saved, I dont think I'll use ChatGPT for code. Itwas fast, but theres no way
 * it can do all the work of understanding how all the files work together and correct the code accordingly.
 */