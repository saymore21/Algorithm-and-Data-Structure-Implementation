
#include <cstdlib> 
#include <iostream> 
#include <chrono>
using namespace std::chrono; 
using namespace std;

int partition(int A[],int B[], int p, int s) 
{ 
	int pivot = A[s]; 
	int i = (p - 1); 

	for (int j = p; j <= s - 1; j++) { 
		if (A[j] <= pivot) { 
			i++;
			swap(A[i], A[j]); 
			swap(B[i], B[j]);
		} 
	} 
	swap(A[i + 1], A[s]); 
	swap(B[i+1], B[s]);
	return (i + 1); 
} 
int partition_r(int A[],int B[], int p, int s) 
{  
	srand(time(NULL)); 
	int random = p + rand() % (s - p);  
	swap(A[random], A[s]);
	swap(B[random], B[s]);
	return partition(A,B, p, s); 
} 
arr[] --> Array to be sorted, 
low --> Starting index, 
high --> Ending index */
void quickSort(int A[],int B[], int p, int s) 
{ 
	if (p < s) { 
		int pi = partition_r(A,B, p, s); 
		quickSort(A,B, p, pi - 1); 
		quickSort(A,B, pi + 1, s); 
	} 
} 

void printArray(int A[],int B[], int size) 
{ 
	int i; 
	for (i = 0; i < size; i++) 
		printf(" %d %d \n ", A[i], B[i]); 
		
	printf("\n"); 
} 

int main() 
{ 
    auto start = high_resolution_clock::now();
	int A[] = { 6,9,13,3,11,13,12,14,9,5,7,1,1,6}; 
	int B[] = { 7,11,14,7,15,14,14,15,15,7,9,5,9,10};
   // int A[] = {5,1,4,8};
  //  int B[] = {7,3,6,10};
	int n = sizeof(A) / sizeof(A[0]); 
	quickSort(A,B, 0, n - 1); 
	printf("Sorted array: \n"); 
	printArray(A,B, n); 
	
	
	auto stop = high_resolution_clock::now();
	auto duration = duration_cast<nanoseconds>(stop - start).count(); 
	cout<<"Total Execution Time is "<<duration;
	 
	return 0; 
}

