package dac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IntegerMaxSubarray extends MaxSubarrayGenericType<Integer>{
    protected Integer add(Integer o1, Integer o2){
        return new Integer(o1.intValue() + o2.intValue());
    }
    protected int compareTo(Integer o1, Integer o2){
        if (o1.intValue() < o2.intValue())
            return -1;
        else
            if (o1.intValue() > o2.intValue())
                return 1;
            else
                return 0;
    }
    
    public static void main(String [] argv){
    	long initTime;
        Scanner keyboard = new Scanner(System.in);
        String intSequence = keyboard.nextLine();
        
        String[] tokens = intSequence.split(",");
        Integer [] array = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++)
            array[i] = new Integer(tokens[i]);
        
        //Integer [] array = {0, 1, -4, 3, 4, -2, 6};
        List<Integer> list = Arrays.asList(array);
        
        ArrayList<Integer> arrayList = new ArrayList<Integer>(list);
        initTime = System.nanoTime(); // Initializing the clock
        IntegerMaxSubarray mss = new IntegerMaxSubarray();
        SubArrayInfoGenericType<Integer> max = mss.findMSS(arrayList, 0, arrayList.size()-1);
        long duration = System.nanoTime() - initTime;
        System.out.println(max.toString());
        System.out.println("Time Elapsed = " + duration + " nanoseconds.");
    }
}
