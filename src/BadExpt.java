import java.util.Comparator;

public class BadExpt {
  public static void main(String args[]){

    Integer[] testarr ={3,9,2,8,6,4,1,7,5};
    Comparator<Integer> intcomp = new Comparator<Integer>(){
      public int compare(Integer int1, Integer int2){
        if(int1 == int2){
          return 0;
        }
        else if( int1 > int2){
          return 1;
        } 
        else if( int1 < int2){
          return -1;
        }
        else return -2;
    }
    };
     /* 
    Quicksort.quicksort(testarr,intcomp, 0, testarr.length);
    Integer[] sortedarr = testarr.clone();
    System.out.print("actual:  {");
    for(int i = 0; i < sortedarr.length - 1; i++){
      System.out.print(sortedarr[i] + ",");
      System.out.flush();
    }
    System.out.print(sortedarr[sortedarr.length - 1] + "}\n");
    System.out.flush();
    System.out.println("want:    {1,2,3,4,5,6,7,8,9}");
*/


Integer[] initial = {9,1,3,11,4,5,7,6,8,12,10,2,13};

System.out.print("initial:  {");
    for(int i = 0; i < initial.length - 1; i++){
      System.out.print(initial[i] + ",");
      System.out.flush();
    }
    System.out.print(initial[initial.length - 1] + "}\n");
    System.out.flush();
    Integer[] sorted = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    MergeSort.sorthelper(initial,0, initial.length, intcomp);

    System.out.print("actual:   {");
    for(int i = 0; i < initial.length - 1; i++){
      System.out.print(initial[i] + ",");
      System.out.flush();
    }
    System.out.print(initial[initial.length - 1] + "}\n");
    System.out.flush();

/*
System.out.print("initial:  {");
    for(int i = 0; i < initial.length - 1; i++){
      System.out.print(initial[i] + ",");
      System.out.flush();
    }
    System.out.print(initial[initial.length - 1] + "}\n");
    System.out.flush();
    Integer[] sorted = {1,2,3,4,5,6,7,8,9,10,11,12};
    MergeSort.merge(initial, 0, initial.length / 2, initial.length, intcomp);
    System.out.print("actual:  {");
    for(int i = 0; i < initial.length - 1; i++){
      System.out.print(initial[i] + ",");
      System.out.flush();
    }
    System.out.print(initial[initial.length - 1] + "}\n");
    System.out.flush();
    //System.out.println("want:   " + sorted.toString());
    */
    /* 
    System.out.print("initial:  {");
    for(int i = 0; i < initial.length - 1; i++){
      System.out.print(initial[i] + ",");
      System.out.flush();
    }
    System.out.print(initial[initial.length - 1] + "}\n");
    System.out.flush();

    new InsertionSort().sort(initial,intcomp);
    Integer[] sortedarr = initial.clone();
    System.out.print("actual:  {");
    for(int i = 0; i < sortedarr.length - 1; i++){
      System.out.print(sortedarr[i] + ",");
      System.out.flush();
    }
    System.out.print(sortedarr[sortedarr.length - 1] + "}\n");
    System.out.flush();
    */
  }//main
}//Expt
