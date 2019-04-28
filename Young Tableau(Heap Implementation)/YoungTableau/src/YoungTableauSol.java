import java.util.Scanner;

public class YoungTableauSol {
	 public static int m = 4;
	 public static int n = 4;
	 public static int i = 0;
	 public static int j = 0;
	 
	 public static int[][] tableau = new int[m][n];
	 
	
	
	 public static void youngify(int [][] young_t, int i, int j)
	 {
		 int x, y;   
         
         x = i;
         y = j;
         int temp;
         if (i + 1 < m){
             if (young_t[i][j] > young_t[i+1][j]){
                 x = i + 1;
                 y = j;
             }
         }
          
         if (j+1 < n){
             if (young_t[x][y] > young_t[i][j+1]){
                 x = i;
                 y = j+1;
             }
         }
          
         if(x != i || y != j){
             temp = young_t[x][y];
             young_t[x][y] = young_t[i][j];
             young_t[i][j] = temp;
             youngify(young_t, x, y);
         }

		      }
	 
	 
	 public static void insert_element(int [][]tab, int i, int j, int element)
	 {
		 if(i==m && j==n)
		    {
		        System.out.println("No more insertions possible. Or the tableau is full");
		        return;
		    }
		    
		    if(j<n-1)
		    {
		        j+=1;
		        tableau[i][j]=element;
		        
		    }
		    else if(i<m-1)
		    {
		        i+=1;
		        j=0;
		        tableau[i][j]=element;
		        
		        
		    }
		    
		    int x,y;
		    int max = Integer.MAX_VALUE;
		    x=i;
		    y=j;
		    int temp=0;
		    int exit=0;
		    while(x>=0 && y >=0 && exit==0)// exit==0 //tableau[i][j]<max
		    {
		        int flag1=0;
		        int flag2=0;
		        if( y>0 && (tableau[x][y-1]>tableau[x][y]) ) // same row different col
		        {
		            //System.out.println("\n inside 1st if");
		            //System.out.println("\nx:%i y:%i tableau[x][y-1]:%i ",x,y,tableau[x][y-1]);
		            temp=tableau[x][y-1];
		            tableau[x][y-1]=tableau[x][y];
		            tableau[x][y]=temp;
		            
		            y-=1;
		            flag1=1;
		            
		            int r=x,s=y+1;
		            //System.out.println("\n element:%i r:%i s:%i",element,r,s);
		            while(r>0 && s>0)// exit==0 //tableau[i][j]<max
		            {
		                int tem2;
		                int flag3=0;
		                if(tableau[r-1][s]>tableau[r][s])
		                {
		                    tem2=tableau[r-1][s];
		                    tableau[r-1][s]=tableau[r][s];
		                    tableau[r][s]=tem2;
		                    
		                    r-=1;
		                    flag3=1;
		                }
		                if(tableau[r][s-1]>tableau[r][s])
		                {
		                    tem2=tableau[r][s-1];
		                    tableau[r][s-1]=tableau[r][s];
		                    tableau[r][s]=tem2;
		                    
		                    s-=1;
		                    flag3=1;
		                }
		                if(flag3 == 0)
		                {
		                    r=-1;
		                }
		            }
		            
		        }
		         if(x>0 && (tableau[x-1][y]>tableau[x][y]))
		        {
		            //System.out.println("\n inside 2nd if");
		            temp=tableau[x-1][y];
		            tableau[x-1][y]=tableau[x][y];
		            tableau[x][y]=temp;
		            
		            x-=1;
		            flag2=1;
		            
		            int r=x+1,s=y;
		            //System.out.println("\n element:%i r:%i s:%i",element,r,s);
		            
		            while(s>0 && r>0)// exit==0 //tableau[i][j]<max
		            {
		                int tem2;
		                int flag3=0;
		                if(tableau[r][s-1]>tableau[r][s])
		                {
		                    tem2=tableau[r][s-1];
		                    tableau[r][s-1]=tableau[r][s];
		                    tableau[r][s]=tem2;
		                    
		                    s-=1;
		                    flag3=1;
		                }
		                if(tableau[r-1][s]>tableau[r][s])
		                {
		                    tem2=tableau[r-1][s];
		                    tableau[r-1][s]=tableau[r][s];
		                    tableau[r][s]=tem2;
		                    
		                    r-=1;
		                    flag3=1;
		                }
		                if(flag3 == 0)
		                {
		                    s=-1;
		                }
		            }
		 
		    
		        }
		        if(flag2==0 && flag1==0)
		        {
		            exit=1;
		        }
		         }
		     }
	 public static int extract_min(int [][]youngT){
	     int x = youngT[0][0];
	     youngT[0][0] = Integer.MAX_VALUE;
	     youngify(youngT, 0, 0);
	     return x;
	 }
	 
	 public static int findElement(int element)
	 {
		// System.out.println("i in find"+i);
			//System.out.println(""+i);
	     int x,y;
	     x=i;
	     y=0;
	     while(i>=0 && y<=n-1)
	     {
	    	 /*System.out.println("x = "+x);
	    	 System.out.println("y = "+y);*/
	         if(tableau[x][y]==element)
	         {
	             return 1;
	         }
	         if(tableau[x][y] < element)
	         {
	             y+=1;
	         }
	        /* System.out.println("in the mid x = "+x);
	    	 System.out.println("in the mid y = "+y);*/
	         if(y <n && tableau[x][y] > element)
	         {
	             x-=1;
	         }
	        // System.out.println("in the end x = "+x);
	    	// System.out.println("in the end y = "+y);
	     }
	     
	    // System.out.println("I am Ending");
	     return 0;
	 }
	 
	 
	 public static void Print(int[][] tableau)
		{
			for(int k = 0 ; k <4; k++)
			{
				for (int l=0; l<4; l++)
				{
					System.out.print(tableau[k][l] + "\t");
				}
				System.out.println();
		}
		
		}
		
		public static void main(String[] args)
		{
			YoungTableauSol yTab = new YoungTableauSol();
			
			int arr[] = {9,16,3,2,4,8,5,14,12};

			//{8,4,2,5,9};
				//{9,16,3,2,4,8,5,14,12};
			for(int a = 0 ; a <m; a++)
			{
				for (int b=0; b<n; b++)
				{
					tableau[a][b] = Integer.MAX_VALUE;
				}
		}
			
			for(int k = 0; k < arr.length; k++)
			{
				insert_element(tableau, i, j, arr[k]);
				j++;
				if(j == 4)
				{
					i++;
					j = 0;
				}
			}
		
			Print(tableau);	
			System.out.println("----------------------------------------------------------------------------"+ "\n");
			int minEle = extract_min(tableau);
			System.out.println("The minimum element is :"+ minEle);
			
			Print(tableau);
			
			System.out.println("----------------------------------------------------------------------------"+ "\n");
			
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter the element to be looked for in the Tableau : ");
			int n = reader.nextInt(); // Scans the next token of the input as an int.
					
			int found = findElement(n);
			if(found == 1)
				System.out.println("The elemnet is present in the Tableau!!");
			else
				System.out.println("The element is not present in the Tableau.");
			
			reader.close();		
		}



}
