package dac;

import java.util.ArrayList;
import java.util.Scanner;

public class AltAlgorithm {
	
	static int maxSubArraySum(int[] a,int size)  
	{  
	      
	    int max_so_far = 0, max_ending_here = 0;  
	  
	    for (int i = 0; i < size; i++)  
	    {  
	        max_ending_here = max_ending_here + a[i]; 
	        if (max_ending_here < 0)  
	            max_ending_here = 0;  
	          
	        else if (max_so_far < max_ending_here)  
	            max_so_far = max_ending_here;  
	          
	    }  
	    return max_so_far;  
	}  
	
	 public static void main (String[] args) 
	    { 
		 long initTime;
	        
		 //ArrayList<Integer> array = new ArrayList<Integer>();
		 Scanner keyboard = new Scanner(System.in);
	        String intSequence = keyboard.nextLine();
	        
	        String[] tokens = intSequence.split(",");
	        int [] array = new int[tokens.length];
	        for (int i = 0; i < tokens.length; i++)
	        	array[i] = new Integer(tokens[i]);
	        	//array.add(Integer.parseInt(tokens[i]));

		 
	        initTime = System.nanoTime(); 
	        System.out.println("Maximum contiguous sum is " + 
	                                       maxSubArraySum(array,array.length)); 
	        long duration = System.nanoTime() - initTime;
	        System.out.println("duration = " + duration);
	    } 


}
