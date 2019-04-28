package algorithm.sort;

public class MergeSort {
   public static void merge(int arr [], int i, int j, int k) {
      int mergedPart = k - i + 1;       
      int mergedarr [] = new int[mergedPart]; 
      int currPos;                   
      int currLeft;                      
      int currRight;                     
      currPos = 0;
      currLeft = i;                      
      currRight = j + 1;                 

      
      while (currLeft <= j && currRight <= k) {
         if (arr[currLeft] < arr[currRight]) {
            mergedarr[currPos] = arr[currLeft];
            ++currLeft;
         } 
         else {
            mergedarr[currPos] = arr[currRight];
            ++currRight;
         }
         ++currPos;
      }

      // If the left partition is having some values, add remaining elements to merged arr
      while (currLeft <= j) {
         mergedarr[currPos] = arr[currLeft];
         ++currLeft;
         ++currPos;
      }

      // If right partition is having any values, add remaining elements to merged arr
      while (currRight <= k) {
         mergedarr[currPos] = arr[currRight];
         ++currRight;
         ++currPos;
      }

      // Copy merge number back to 0riginal arr
      for (currPos = 0; currPos < mergedPart; ++currPos) {
         arr[i + currPos] = mergedarr[currPos];
      }
   }

   public static void sort(int arr [], int i, int k) {
      int j;

      if (i < k) {
         j = (i + k) / 2;  // Find the midpoint in the partition

         // Recursively sort left and right partitions
         sort(arr, i, j);
         sort(arr, j + 1, k);

         // Merge left and right partition in sorted order
         merge(arr, i, j, k);
      }
   }

   public static void main(String [] args) {
      int arr [] = {8,2,4,74,1,26,14,9};
      final int arr_SIZE = 8;
      int i;

      System.out.print("-----------Merge Sort---------\nUNSORTED: ");
      for (i = 0; i < arr_SIZE; ++i) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();

      /* Call to the Merge Sort Function
      sort(arr, 0, arr_SIZE - 1);

      System.out.print("SORTED: ");
      for (i = 0; i < arr_SIZE; ++i) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}
