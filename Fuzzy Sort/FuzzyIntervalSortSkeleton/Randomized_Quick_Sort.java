
	import java.util.Random;
	 
	public class Randomized_Quick_Sort 
	{
	    //public static int N = 20;
	   // public static int[] A = new int[N];
	  //  public static int[] B = new int[N];
	    
	    public static int partition(int arr[],int B[], int low, int high) 
	    { 
	        int pivot = arr[high]; 
	        int i = (low - 1); 
	        for (int j = low; j <= high - 1; j++) { 
	            if (arr[j] <= pivot) { 
	                i++; 
	                swap(arr, i, j); 
	    	        swap(B, i, j);
	            } 
	        } 
	        swap(arr, i + 1, high); 
	        swap(B,i + 1, high);
	        return (i + 1); 
	    } 
	 
	    
	    public static int partition_r(int arr[],int B[], int low, int high) 
	    { 
	    	Random rand = new Random();
	    	int random = low + rand.nextInt(high - low);
	        swap(arr, random, high);
	        swap(B, random, high);
	        return partition(arr,B, low, high); 
	    } 
	    
	    public static void quickSort(int A[],int B[], int low, int high) 
	    { 
	        if (low < high) { 
	              int pi = partition_r(A,B, low, high); 
	              quickSort(A,B, low, pi - 1); 
	              quickSort(A,B, pi+1, high); 
	        } 
	    } 

	    
	   
	     public static void swap(int[] arr,int dex1, int dex2) 
	    {
	        int temp = arr[dex1];
	        arr[dex1] = arr[dex2];
	        arr[dex2] = temp;
	        
	    }
	     
	     
	    static void printSequence(int[] sorted_sequenceA, int[] sorted_sequenceB) 
	    {
	        for (int i = 0; i < sorted_sequenceA.length; i++)
	            System.out.print(sorted_sequenceA[i] + ", " +sorted_sequenceB[i] + "\n");
	    }
	 
	    public static void main(String args[]) 
	    {
	    	long startTime, duration;
	        System.out.println("Sorting of randomly generated numbers using RANDOMIZED QUICK SORT");
	        
	       /* int A[] = {5, 1, 4, 8}; 
	       // int n = sizeof(A)/sizeof(A[0]); 
	        int B[] = {7, 3, 6, 10};
	 
	        System.out.println("\nBefore the sorting: ");
	        printSequence(A,B);
	        System.out.println("After the sorting: ");
	        startTime = System.nanoTime();
	        quickSort(A,B, 0, A.length - 1);
	        duration = System.nanoTime() - startTime;
	        printSequence(A,B);
	        
	        System.out.println("\n");
	        System.out.println("Total time taken for Execution: " +duration);*/
	        
	        int Arr_A[] = {6, 9, 13, 3, 11, 13, 12, 14, 9, 5, 7, 1, 1, 6};
	        int Arr_B[] = {7, 11, 14, 7, 15, 14, 14, 15, 15, 7, 9, 5, 9, 10};
	        
	        System.out.println("\nBefore the sorting: ");
	        printSequence(Arr_A,Arr_B);
	        System.out.println("After the sorting: ");
	        startTime = System.nanoTime();
	        quickSort(Arr_A,Arr_B, 0, Arr_A.length - 1);
	        duration = System.nanoTime() - startTime;
	        printSequence(Arr_A,Arr_B);
	        
	        System.out.println("\n");
	        System.out.println("Total time taken for Execution: " +duration);
	    }
	}

