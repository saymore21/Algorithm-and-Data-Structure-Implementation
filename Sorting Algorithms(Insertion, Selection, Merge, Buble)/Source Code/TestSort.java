package algorithm.testset.util;

/* Codestyle adapted from Prof. Dr. Quiong's code*/

import algorithm.sort.InsertionSort;
import algorithm.sort.MergeSort;
import algorithm.sort.SelectionSort;
import java.util.ArrayList;


public class TestSort {
    public final static int NUMBER_OF_SORTS = 3;
    public final static int INSERTION_SORT = 1;
    public final static int SELECTION_SORT = 2;
    public final static int MERGE_SORT = 3;
    public final static int INPUT_INSTANCE_arrSize = 0;
    
    public final static int REPEATS = 10;
    
    public static long [] testframework(int []arr, boolean toPrint){

        long initTime;        
        if (arr == null) return null;// If the input array is empty then return Null
        
        int arrSize= arr.length;
        long duration[] = new long[NUMBER_OF_SORTS + 1];// number of sorts + 1  to store the inout size
        duration[INPUT_INSTANCE_SIZE] = arrSize;
        int tmp [] = new int[arrSize]; 
        for (int i = 0; i < arrSize; i++)
            tmp[i] = arr[i];
        
        
        initTime = System.nanoTime(); // Initializing the clock
        InsertionSort.sort(tmp, arrSize);
        duration[INSERTION_SORT] = System.nanoTime() - initTime;
        if (toPrint) System.out.print(duration[INPUT_INSTANCE_SIZE] + "\t" + duration[INSERTION_SORT] + "\t");

        for (int i = 0; i < arrSize; i++)
            tmp[i] = arr[i];
        initTime = System.nanoTime();
        SelectionSort.sort(tmp, arrSize);
        duration[SELECTION_SORT] = System.nanoTime() - initTime;
        if (toPrint) System.out.print(duration[SELECTION_SORT] + "\t");

        for (int i = 0; i < arrSize; i++)
            tmp[i] = arr[i];
        initTime = System.nanoTime();
        MergeSort.sort(tmp, 0, arrSize-1);
        duration[MERGE_SORT] = System.nanoTime() - initTime;
        if (toPrint) System.out.println(duration[MERGE_SORT]);
        
        return duration;
    }
    
      public static void test_Best_Worst(int arrSize_start,int arrSize_end, int arrSize_chunks, String title, boolean isBestCase){
        System.out.println("-----------------" + title + "-----------------");
        System.out.println("Input instance arrSize\tInsertion Sort\tSelection Sort\tMergeSort");
        ArrayList<Integer> list;
        
        int times = (arrSize_end - arrSize_start + 1) % arrSize_chunks == 0
                ? (arrSize_end - arrSize_start + 1) / arrSize_chunks
                : (arrSize_end - arrSize_start + 1) / arrSize_chunks + 1;
                
                
         int count = 0;
         long duration[][] = new long[times][NUMBER_OF_SORTS + 1];
         long tmp_duration[];
         long total_duration[] = new long[NUMBER_OF_SORTS + 1];
                
         for (int i = arrSize_start; i<= arrSize_end; i+=arrSize_chunks){
                    for (int j = 0; j < REPEATS; j++)
                        for (int k = 0; k < NUMBER_OF_SORTS + 1; k++ )
                            total_duration[k] = 0;
                    
                    for (int j = 0; j < REPEATS; j++){
                        list = CollectionGenerator.generateRandomArrayList(i, isBestCase?1:-1);
                        int [] array = Common.copy2Array(list);
                        tmp_duration = testframework(array, false);
                        
                        for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                            total_duration[k] += tmp_duration[k];
                    }
                    
                    for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                        duration[count][k] = total_duration[k] / REPEATS;
                    
                    count++;
                }
                
                for (int i = 0; i < count; i++)
                    System.out.println(duration[i][INPUT_INSTANCE_SIZE] 
                            + "\t" + duration[i][INSERTION_SORT]
                            + "\t" + duration[i][SELECTION_SORT]
                            + "\t" + duration[i][MERGE_SORT]);        
  
    }
    
    
    public static void testAverage(int arrSize_start,int arrSize_end, int arrSize_chunks, String title){
        System.out.println("-----------------" + title + "-----------------");
        System.out.println("Input instance arrSize\tInsertion Sort\tSelection Sort\tMergeSort");
        ArrayList<Integer> list;
        
        int times = (arrSize_end - arrSize_start + 1) % arrSize_chunks == 0
                ? (arrSize_end - arrSize_start + 1) / arrSize_chunks
                : (arrSize_end - arrSize_start + 1) / arrSize_chunks + 1;
        int count = 0;
        long duration[][] = new long[times][NUMBER_OF_SORTS + 1];
        long tmp_duration[];
        long total_duration[] = new long[NUMBER_OF_SORTS + 1];
        
        for (int i = arrSize_start; i<= arrSize_end; i+=arrSize_chunks){
            for (int j = 0; j < REPEATS; j++)
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++ )
                    total_duration[k] = 0;
            
            for (int j = 0; j < REPEATS; j++){
                list = CollectionGenerator.generateRandomArrayList(i, -1); 
                int [] array = Common.copy2Array(list);
                tmp_duration = testframework(array, false);
                
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                    total_duration[k] += tmp_duration[k];
            }
            
            for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                duration[count][k] = total_duration[k] / REPEATS;
            
            count++;
        }
        
        for (int i = 0; i < count; i++)
            System.out.println(duration[i][INPUT_INSTANCE_SIZE] 
                    + "\t" + duration[i][INSERTION_SORT]
                    + "\t" + duration[i][SELECTION_SORT]
                    + "\t" + duration[i][MERGE_SORT]);
    }
    
    public static void main(String[] argv){

        test_Best_Worst(100, 10000, 100, "Comparison [base case]", false);
        test_Best_Worst(100, 10000, 100, "Comparison [worse case]", false);
        
        testAverage(100, 10000, 100, "Comparison [average case]");
    }
}
