package algorithm.sort;

public class SelectionSort {
   public static void sort(int arr [], int arrSize) {
      int i;
      int j;
      int minIndex;
      int temp;      

      for (i = 0; i < arrSize; ++i) {

         // Considering the minimum element index to be the current index
         minIndex = i;
         for (j = i + 1; j < arrSize; ++j) {

            if (arr[j] < arr[minIndex]) {
               minIndex = j;
            }
         }

         // Swap arr[i] and arr[minIndex]
         temp = arr[i];
         arr[i] = arr[minIndex];
         arr[minIndex] = temp;
      }
   }

   public static void main(String [] args) {
      int arr [] = {8,2,4,74,1,26,14,9};
      final int arr_SIZE = 8;
      int i;

      System.out.print("-----------Selection Sort---------\nUNSORTED: ");
      for (i = 0; i < arr_SIZE; ++i) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();

      /* initial call to quicksort with index */
      sort(arr, arr_SIZE);

      System.out.print("SORTED: ");
      for (i = 0; i < arr_SIZE; ++i) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}