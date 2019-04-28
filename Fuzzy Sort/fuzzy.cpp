/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <iostream>
#include <stdlib.h>
#include <chrono>
using namespace std::chrono;
using namespace std;

void exchange (int Arr[],int a, int b)
{
    int temp;
    
    temp=Arr[b];
    Arr[b]=Arr[a];
    Arr[a]=temp;
}

int  partitionright(int A[], int B[],int a,int p,int s)
{
    int i = p - 1;

    for (int j=p ;j<= s - 1;j++)
    {
        if (A[j] <= a)
        {
            i = i + 1;
            exchange (A,i,j);
            exchange (B,i,j);
        }
    }
    exchange (A,i + 1,s);
    exchange (B,i + 1,s);
    return i + 1;
}
    
    
    
    
int partitionleftmiddle(int A[],int B[],int b,int p,int r)
{
    int i = p - 1;
        for (int j=p ;j<= r - 1;j++)
        {
            if (B[j] < b)
            {
                i= i + 1;
                exchange (A,i,j);
                exchange (B,i,j);
            }
        }
        exchange (A,i + 1, r);
        exchange (B,i + 1, r);
    return i + 1;
}


int * findintersection(int A[],int  B[],int p, int s, int a, int b)
{
    int i = rand() % s + p;
    static int arr[2];
    
    //exchange (A,i,s);
    //exchange (B,i,s);
    
    a = A[s];
    b = B[s];
    
    for (int j=p; j<=s-1; j++)
    {
        if( (A[j] <= b ) && ( a <= B[j] ))
        {
            if (A[j] > a)
                a = A[j];
            if (B[j] < b);
                b = B[j];
        }
    }
    arr[0]=a;
    arr[1]=b;
    
    return arr;
} 
        
    
    
    
void fuzzysort( int A[],int B[], int p, int s)
{
    //printf("\n inside fuzzy sort");
        if (p < s)
        {
            int a = 0; 
            int b = 0;
            int* arr;
            
            arr=findintersection(A, B, p, s, a, b);
            a = *(arr + 0);
            b = *(arr + 1);
            
            int r = partitionright(A, B, a, p, s);
            int q = partitionleftmiddle(A, B, b, p, r);
            fuzzysort(A, B, p, q - 1);
            fuzzysort(A, B, r + 1, s);
        }
       
        
}


int main ()
{
    auto start = high_resolution_clock::now();
    int A[] = { 6,9,13,3,11,13,12,14,9,5,7,1,1,6};
    int B[] = {7,11,14,7,15,14,14,15,15,7,9,5,9,10};
   // int A[]={5,1,4,8};
   // int B[]={7,3,6,10};
 fuzzysort(A,B,0,13);
 auto stop = high_resolution_clock::now();
 for(int k=0;k<14;k++)
 {
     printf("\n%i %i",A[k],B[k]);
 }
 
	auto duration = duration_cast<nanoseconds>(stop - start).count(); 
	cout<<"\n Total Execution Time is "<<duration;

 return 0;
}