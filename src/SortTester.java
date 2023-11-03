import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+
  @Test
  public void intTest1() {
    Integer[] initial = {9,1,3,11,4,5,7,12,8,6,10,2,13};
    Integer[] sorted = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    Comparator<Integer> intcomp = new Comparator<Integer>(){
      public int compare(Integer int1, Integer int2){
        if(int1 == int2){
          return 0;}// ==
        else if( int1 < int2){
          return -1;} // >
        else if( int1 > int2){
          return 1;}// <
        else return -2;}//comparator
    };//intcomp
    sorter.sort(initial, intcomp);
    assertArrayEquals(initial, sorted);
  } // intTest1()

  @Test
  public void intTest2() {
    Integer[] initial = {1,1,1,1,1,1,1,1,1,1,1,1};
    Integer[] sorted = {1,1,1,1,1,1,1,1,1,1,1,1};
    Comparator<Integer> intcomp = new Comparator<Integer>(){
      public int compare(Integer int1, Integer int2){
        if(int1 == int2){
          return 0;}// ==
        else if( int1 < int2){
          return -1;} // >
        else if( int1 > int2){
          return 1;}// <
        else return -2;}//comparator
    };//intcomp
    sorter.sort(initial, intcomp);
    assertArrayEquals(initial, sorted);
  } // intTest2()

  @Test
  public void intTest3() {
    Integer[] initial = {12,2,3,4,5,6,7,8,9,10,11,1};
    Integer[] sorted = {1,2,3,4,5,6,7,8,9,10,11,12};
    Comparator<Integer> intcomp = new Comparator<Integer>(){
      public int compare(Integer int1, Integer int2){
        if(int1 == int2){
          return 0;}// ==
        else if( int1 < int2){
          return -1;} // >
        else if( int1 > int2){
          return 1;}// <
        else return -2;}//comparator
    };//intcomp
    sorter.sort(initial, intcomp);
    assertArrayEquals(initial, sorted);
  } // intTest3()
  @Test
  public void intTest4() {
    Integer[] initial = {1,2,1,1,2,3,3,2,2,1,2,3,3,2};
    Integer[] sorted = {1,1,1,1,2,2,2,2,2,2,3,3,3,3};
    Comparator<Integer> intcomp = new Comparator<Integer>(){
      public int compare(Integer int1, Integer int2){
        if(int1 == int2){
          return 0;}// ==
        else if( int1 < int2){
          return -1;} // >
        else if( int1 > int2){
          return 1;}// <
        else return -2;}//comparator
    };//intcomp
    sorter.sort(initial, intcomp);
    assertArrayEquals(initial, sorted);
  } // intTest4()

@Test
  public void emptTest() {
    Integer[] initial = {};
    Integer[] sorted = {};
    Comparator<Integer> intcomp = new Comparator<Integer>(){
      public int compare(Integer int1, Integer int2){
        if(int1 == int2){
          return 0;}// ==
        else if( int1 < int2){
          return -1;} // >
        else if( int1 > int2){
          return 1;}// <
        else return -2;}//comparator
    };//intcomp
    sorter.sort(initial, intcomp);
    assertArrayEquals(initial, sorted);
  } // emptTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

} // class SortTester
