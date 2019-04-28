#include <iostream>
#include <stdlib.h>
#include <chrono>
using namespace std;

void swap(int arr[],int index1, int index2)
{
    int temp=0;
    temp=arr[index1];
    arr[index1]=arr[index2];
    arr[index2]=temp;
    
    //return NULL;
}

int *FindIntersection(int A[], int B[], int p, int s, int a, int b)  
{
      int i = rand() % s + p;
      //int i=2;
      static int r[2];
      //printf("\n\ni:%i\n",i);
      //swap(A,i,s);//exchange A[i] with A[s]  
      //swap(B,i,s);//exchange B[i] with B[s]  
      a = A[s]; 
      b = B[s]; 
      for (int i =p ;i<=s-1 ;i++)
      {
              if (A[i] <= b && B[i] >= a)
              {
                  if (A[i] > a)  
                        a =A[i];
                  if (B[i] < b) 
                        b =B[i];
              }
      }
      r[0]=a;
      r[1]=b;
      
      //printf("\n\na:%i b:%i",(r+ 0),(r+ 1));
      return r;
     
}


int PartitionRight(int A[], int B[], int a, int p, int s)
{
 
      int i = p - 1; 
      for (int j=p ;j<= s-1 ; j++)
      {
            if (A[j] <= a)
            {
              i =i + 1; 
              swap(A,i,j);//exchange A[i] with A[j] 
              swap(B,i,j);//exchange B[i] with B[j] 
              
            }
      }
      swap(A,i+1,s);//exchange A[i + 1] with A[s]  
      swap(B,i+1,s);//exchange B[i + 1] with B[s]
        
     return i + 1;
}


int PartitionLeftMiddle(int A[], int B[], int b, int p, int r)
{
  int i = p - 1;  
  for (int j=p; j<= r - 1;j++)
  {
        if (B[j] < b)
        {
          i = i + 1;  
          swap(A,i,j);//exchange A[i] with A[j] 
          swap(B,i,j);//exchange B[i] with B[j] 
           
        }
  }
   swap(A,i+1,r);//exchange A[i + 1] with A[r]  
   swap(B,i+1,r);//exchange B[i + 1] with B[r]
    return i + 1;
}                                                                                             

void FuzzySort(int A[], int B[], int p, int s)
{
    //printf("\ninside fuzzy with p:%i s:%i",p,s);
     int a,b,r,q;
     int *arr;
     if (p < s)
     {
        a = 0;
        b = 0;
        arr=FindIntersection(A, B, p, s, a, b); 
      
         //printf("\na:%i b:%i",(int)arr[0],(int)arr[1]);//(arr + 0),(arr + 1)
         a= *(arr + 0);
         b= *(arr + 1);
         
         r =PartitionRight(A, B, a, p, s);
         q =PartitionLeftMiddle(A, B, b, p, r);
         
         FuzzySort(A, B, p, q - 1); 
         FuzzySort(A, B, r + 1, s);
         //return NULL;
     }
     else
     {
         return;
     }
     

}

int main()
{
    //cout<<"Hello World";
    auto start = chrono::steady_clock::now();
    int A[] = {5, 1, 4, 8}; 
    int B[] = {7,3,6,10};
    FuzzySort(A,B,0,3);
     auto end = chrono::steady_clock::now();
    for(int i=0;i<4;i++)
    {
        printf("%i   %i\n",A[i],B[i]);
    }
   
   cout<<"Time elapsed:"<<chrono::duration_cast<chrono::nanoseconds>(end-start).count();
    //QuickSort();
    return 0;
    
}