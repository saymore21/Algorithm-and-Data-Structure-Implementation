package algorithm.sort;

public class BubbleSort {
    public static void sort(int arr[], int arrSize) {
        int i=0,k=0,temp=0;
        int sorted_flag=1;
        for(k = 0;k < arrSize -1; k++) {
            sorted_flag=1;
            for(i=0;i < arrSize - k - 1;i++) {// as bubble sort always pushes the largest elements to the end of the list the loop ending condition is reduced by one after every iteration
                        
                if(arr[i] > arr[i+1] ) {
                    temp=arr[i];            
                    arr[i]=arr[i+1];    
                    arr[i+1]=temp;          
                    sorted_flag=0;                
                }
            }
            if(sorted_flag==1) {
                break;
            }
        }
   }
    
	public static void main(String[] args) {
		int arr[] = {8,2,4,74,1,26,14,9};
		int n = 8;
		int i=0,k=0,temp=0;
		int sorted_flag=1;
		System.out.print("UNSORTED: ");
		for (i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

                // Call to the Bubble Sort Function
                BubbleSort.sort(arr, n);
		System.out.print("SORTED: ");
		for (i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
	

}
