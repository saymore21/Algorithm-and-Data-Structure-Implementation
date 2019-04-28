/*
 * Code adapted from Prof. Dr. Qiong's Code
 */
package algorithm.testset.util;

import algorithm.sort.InsertionSort;
import algorithm.sort.MergeSort;
import algorithm.sort.SelectionSort;
import algorithm.sort.BubbleSort;
import java.util.ArrayList;

public class testsortwithbubble {
    public final static int NUMBER_OF_SORTS = 4;
    public final static int INSERTION_SORT = 1;
    public final static int SELECTION_SORT = 2;
    public final static int MERGE_SORT = 3;
    public final static int BUBBLE_SORT = 4;
    public final static int INPUT_INSTANCE_SIZE = 0;
    
    public final static int REPEATS = 100;
    
    
    public static long [] testframework(int []arr, boolean doPrint)
    {
        long initTime; int size = arr.length;
        
        if (arr == null) return null;// Return Null if the array is empty
        
        long duration[] = new long[NUMBER_OF_SORTS + 1];
        duration[INPUT_INSTANCE_SIZE] = size;
        int temp_array [] = new int[size]; 
        for (int i = 0; i < size; i++) 
            temp_array[i] = arr[i];
        
        initTime = System.nanoTime(); // Initializing the clock
        InsertionSort.sort(temp_array, size);
        duration[INSERTION_SORT] = System.nanoTime() - initTime;
        if (doPrint) System.out.print(duration[INPUT_INSTANCE_SIZE] + "\t" + duration[INSERTION_SORT] + "\t");

        for (int i = 0; i < size; i++)  
            temp_array[i] = arr[i];
        initTime = System.nanoTime();
        SelectionSort.sort(temp_array, size);
        duration[SELECTION_SORT] = System.nanoTime() - initTime;
        if (doPrint) System.out.print(duration[SELECTION_SORT] + "\t");

        for (int i = 0; i < size; i++)  
            temp_array[i] = arr[i];
        initTime = System.nanoTime();
        MergeSort.sort(temp_array, 0, size-1);
        duration[MERGE_SORT] = System.nanoTime() - initTime;
        if (doPrint) System.out.print(duration[MERGE_SORT] + "\t"); 
        
        for (int i = 0; i < size; i++)   
            temp_array[i] = arr[i];
        initTime = System.nanoTime();
        BubbleSort.sort(temp_array, size);
        duration[BUBBLE_SORT] = System.nanoTime() - initTime;
        if (doPrint) System.out.println(duration[BUBBLE_SORT] ); 
        
        return duration;
    }
    
   
    public static void test_Best_Worse(int size_start, int size_end, int size_chunks, String title, boolean isBestCase){
        System.out.println("-----------------" + title + "-----------------");
        System.out.println("Input instance size\tInsertion Sort\tSelection Sort\tMergeSort\tBubbleSort");
        ArrayList<Integer> list;
        
        int times = (size_end - size_start + 1) % size_chunks == 0
                ? (size_end - size_start + 1) / size_chunks
                : (size_end - size_start + 1) / size_chunks + 1;
        int count = 0;
        long duration[][] = new long[times][NUMBER_OF_SORTS + 1];
        long temp_array_duration[];
        long total_duration[] = new long[NUMBER_OF_SORTS + 1];
        
        for (int i = size_start; i<= size_end; i+=size_chunks){
            for (int j = 0; j < REPEATS; j++)
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++ )
                    total_duration[k] = 0;
            
            for (int j = 0; j < REPEATS; j++){ //Repeats the code for 100 times
            	list = CollectionGenerator.generateRandomArrayList(i, isBestCase?1:-1); // If the best case is to be tested then the array is sorted in ascending order else the array is //sorted in descending order
                int [] array = Common.copy2Array(list);
                temp_array_duration = testframework(array, false);
                
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                    total_duration[k] += temp_array_duration[k];
            }
            
            for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                duration[count][k] = total_duration[k] / REPEATS; // takes the average of the timings for 100 times run
            
            count++;
        }
        
        for (int i = 0; i < count; i++)
            System.out.println(duration[i][INPUT_INSTANCE_SIZE]
                    + "\t" + duration[i][INSERTION_SORT]
                    + "\t" + duration[i][SELECTION_SORT]
                    + "\t" + duration[i][MERGE_SORT]
                    + "\t" + duration[i][BUBBLE_SORT]);

    }
    
   
    public static void testAverage(int size_start, int size_end, int size_chunks, String title){
        System.out.println("-----------------" + title + "-----------------");
        System.out.println("Input instance size\tInsertion Sort\tSelection Sort\tMergeSort\tBubbleSort");
        ArrayList<Integer> list;
        
        int times = (size_end - size_start + 1) % size_chunks == 0
                ? (size_end - size_start + 1) / size_chunks
                : (size_end - size_start + 1) / size_chunks + 1;
        int count = 0;
        long duration[][] = new long[times][NUMBER_OF_SORTS + 1];
        long temp_array_duration[];
        long total_duration[] = new long[NUMBER_OF_SORTS + 1];
        
        for (int i = size_start; i<= size_end; i+=size_chunks){
            for (int j = 0; j < REPEATS; j++)
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++ )
                    total_duration[k] = 0;
            
            for (int j = 0; j < REPEATS; j++){
                list = CollectionGenerator.generateRandomArrayList(i, -1); 
                int [] array = Common.copy2Array(list);
                temp_array_duration = testframework(array, false);
                
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                    total_duration[k] += temp_array_duration[k];
            }
            
            for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                duration[count][k] = total_duration[k] / REPEATS;
            
            count++;
        }
        
        for (int i = 0; i < count; i++)
            System.out.println(duration[i][INPUT_INSTANCE_SIZE]
                    + "\t" + duration[i][INSERTION_SORT]
                    + "\t" + duration[i][SELECTION_SORT]
                    + "\t" + duration[i][MERGE_SORT]
                    + "\t" + duration[i][BUBBLE_SORT]);
    }
    
    public static void main(String[] argv){
      
        test_Best_Worse(100, 10000, 100, "Comparison [best case]", false);
        test_Best_Worse(100, 10000, 100, "Comparison [worse case]", false);
        
        testAverage(100, 10000, 100, "Comparison [average case]");
    }
}
