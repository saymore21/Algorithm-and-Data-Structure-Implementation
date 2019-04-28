package algorithm.sort;

public class InsertionSort {
   public static void sort(int arr[], int arrSize) {
      int i;
      int j;
      int temp;      

      for (i = 1; i < arrSize; ++i) {
         j = i;
         while (j > 0 && arr[j] < arr[j - 1]) {
            temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            j = j-1;
         }
      }
   }

   public static void main(String [] args) {
      int arr [] = {8,2,4,74,1,26,14,9};
      final int ARR_SIZE = 8;
      int i;

      System.out.print("-----------Insertion Sort---------\nUNSORTED: ");
      for (i = 0; i < ARR_SIZE; ++i) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
      sort(arr, ARR_SIZE);

      System.out.print("SORTED: ");
      for (i = 0; i < ARR_SIZE ; ++i) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}
