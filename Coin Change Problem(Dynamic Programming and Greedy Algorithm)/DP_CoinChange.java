import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class DP_CoinChange {

	private static void minCoins(Integer[] coins, int len, int c) { 
	      
        int table[] = new int[c + 1]; 
        //Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        table[0] = 0; 
        
        for (int i = 1; i <= c; i++) {
        	table[i] = Integer.MAX_VALUE; 
        }
        	
        
        for (int i = 1; i <= c; i++) 
        { 
            
            for (int j = 0; j < len; j++) 
            if (coins[j] <= i) 
            { 
            	int temp = table[i - coins[j]]; 
                
                	table[i] = Math.min(temp + 1, table[i]);          
                  
            } 
              
        } 
        System.out.println("Total Coins: "+ table[c]);
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
		int size = denom.length;
		
		 System.out.println ("What is the cents value you want to get change for?");
	     int cent_val = input.nextInt();
	     System.out.println();

		minCoins(denom, size, cent_val);	
		
		input.close();
		
		
	}
	
}
