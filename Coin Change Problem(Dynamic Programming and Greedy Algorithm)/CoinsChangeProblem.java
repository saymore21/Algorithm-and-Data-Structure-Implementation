import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinsChangeProblem {
	
	public static void coinChange(Integer[] denom, int n)
	{
		int remaining = n;
		int coinCount=0;
		
		Integer[] denom_arr = new Integer[denom.length];
		
		for(int k = 0; k< denom_arr.length; k++)
		{
			denom_arr[k] = 0;
		}
		
	    if(n==0)
	    {
	        System.out.println("Total number of coins is 0");
	        return;
	    }
	    else
	    {
	    	while(remaining > 0)
	    	{
	    		for(int j=0; j< denom.length; j++)
	    		{
	    			if(remaining >= denom[j])
	    			{
	    				remaining -= denom[j];
	    				denom_arr[j]++;
	    				coinCount++;
	    				break;
	    			}
	    			
	    		}
	    				
	    		}
	    	}
	    	
	    	
	    	
	   
	    
	    Print(denom_arr, denom);   
	    System.out.println();
	    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	    System.out.println();
	    System.out.println("Total Count of coins: " +coinCount);
	}
	
	public static void Print(Integer[] array, Integer[] denom)
	{
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i] > 0)
			{
				System.out.println(array[i] + " coin(s) of denomination " + denom[i] );	
			}
					   
		}
	}
	
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		
		 System.out.println ("How many denominations do you have?");
	        int num = input.nextInt();
	        Integer denom[] = new Integer[num];

	        for (int i = 0; i < num; i++) {
	            System.out.println ("denom" + i + ":");
	            denom[i] = input.nextInt();
	        }
	        
	   
	        Arrays.sort(denom, Collections.reverseOrder());


	        System.out.println ("What is the cents value you want to get change for?");
	        int cent_val = input.nextInt();
	        System.out.println();
	        coinChange(denom, cent_val);
	        input.close();
	        
	}
	

}
