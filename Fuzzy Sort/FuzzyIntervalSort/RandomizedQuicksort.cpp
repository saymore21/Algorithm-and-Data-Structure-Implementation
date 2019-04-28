#include <cstdlib> 
#include <iostream>
#include <chrono>
using namespace std; 

int partition(int arr[],int B[], int low, int high) 
{ 
    int pivot = arr[high]; 
    int i = (low - 1); 
    for (int j = low; j <= high - 1; j++) { 
        if (arr[j] <= pivot) { 
            i++; 
            swap(arr[i], arr[j]); 
            swap(B[i],B[j]);
        } 
    } 
    swap(arr[i + 1], arr[high]); 
    swap(B[i + 1], B[high]);
    return (i + 1); 
} 
  
int partition_r(int arr[],int B[], int low, int high) 
{ 
    srand(time(NULL)); 
    int random = low + rand() % (high - low); 
    swap(arr[random], arr[high]); 
    swap(B[random], B[high]);
    return partition(arr,B, low, high); 
} 
  

void quickSort(int arr[],int B[], int low, int high) 
{ 
    if (low < high) { 
          int pi = partition_r(arr,B, low, high); 
          quickSort(arr,B, low, pi - 1); 
          quickSort(arr,B, pi + 1, high); 
    } 
} 
  

void printArray(int arr[],int B[], int size) 
{ 
    int i; 
    for (i = 0; i < size; i++) 
        printf("%d %d \n", arr[i],B[i]); 
    printf("\n"); 
} 
  
int main() 
{ 
    auto start = chrono::steady_clock::now();
    int A[] = {5, 1, 4, 8}; 
    int n = sizeof(A)/sizeof(A[0]); 
    int B[] = {7,3,6,10};
    quickSort(A,B, 0, n - 1); 
    printf("Sorted array: \n"); 
    printArray(A,B, n); 
    auto end = chrono::steady_clock::now();
    cout<<"Time elapsed:"<<chrono::duration_cast<chrono::nanoseconds>(end-start).count();
    return 0; 
} 