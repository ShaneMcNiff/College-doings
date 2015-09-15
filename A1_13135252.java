/* Project that takes in a .txt file and returns 
   the minumum sub vector with the largest sum
   using Kadanes algorithm.*/

import java.util.*;
import java.io.*;
public class A1_13135252
{
    public static void main (String[]args) throws IOException
    {
        //Start of the validation of program : checks for the right amount of arguements submitted in CMD
        if(args.length == 0)
            System.out.print("Usage: java ShaneMcNiff \".txt file\"");
        
        else
        {
            String input = args[0], line = "";
            File file = new File(input);
            //Quick check to ensure file exists before running program
            if(file.exists())
            {
                Scanner scanner = new Scanner(file);
                
                //Loop ensures initial string gets all the information from file
                while(scanner.hasNext())
                {
                    line += scanner.nextLine();
                }
                
                float []splitFloatArray = FillArray(line); 
                KadanesAlgoritm(splitFloatArray);
            }
            else
                System.out.print("File not found.");//If file does not exist
        }
    }
    
    public static float[] FillArray(String line)
    {
        //Removing the "," between the numbers and putting each number into a spot in the array as a String
                String []splitLine = line.split(",");
                float []splitFloatArray = new float [splitLine.length];
                int i;
                
                //Changing each string to a float one by one into the new float array
                for(i = 0; i < splitFloatArray.length; i++)
                {
                    splitFloatArray[i] = Float.parseFloat(splitLine[i]);
                }
                return splitFloatArray;
    }
    
    public static void KadanesAlgoritm(float []splitFloatArray)
    {
        float maxSum = 0, cumulativeSum = 0, eachArrayItem = 0;
        int maxStartIndex = 0, maxEndIndex = 0, maxStartIndexUntilNow = 0;
                for (int currentIndex = 0; currentIndex < splitFloatArray.length; currentIndex++)
                {
                    //Current float in array being examined
                    eachArrayItem = splitFloatArray[currentIndex];
                    
                    //Keeps track of current max sum
                    cumulativeSum += eachArrayItem;
                    
                    /*
                    If the floats up until this point are greater than the previous maxSum,
                    set the maxSum to the full amount at this point so that it can be compared
                    during the next floats evaluation.
                    
                    The maxStartIndex is recorded as the point in the array.
                    
                    The maxEndIndex will be updated each run through provided the maxSum increases
                    */
                    if(cumulativeSum > maxSum)
                    {
                        maxSum = cumulativeSum;
                        maxStartIndex = maxStartIndexUntilNow;
                        maxEndIndex = currentIndex;
                    }
                    
                    /*
                    If cumulativeSum drops below zero, we have to start again as
                    we have already taken in too many negative numbers.
                    The start index is now equal to the next position in the array.
                    */
                    else if(cumulativeSum < 0)
                    {
                        maxStartIndexUntilNow = currentIndex + 1;
                        cumulativeSum=0;
                    }
                }
                System.out.println("Max sum         : "+maxSum);
                System.out.println("Max start index : "+maxStartIndex);
                System.out.println("Max end index   : "+maxEndIndex);
    }
}

// I used this section of code to implement Kadanes algorithm

/*https://gist.github.com/arunma/3624849
public static void findMaxSubArray(int[] inputArray){

        int maxStartIndex=0;
        int maxEndIndex=0;
        int maxSum = Integer.MIN_VALUE; 

        int cumulativeSum= 0;
        int maxStartIndexUntilNow=0;
        		
        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {
        	
            int eachArrayItem = inputArray[currentIndex];
            
            cumulativeSum+=eachArrayItem;

            if(cumulativeSum>maxSum){
                maxSum = cumulativeSum;
                maxStartIndex=maxStartIndexUntilNow;
                maxEndIndex = currentIndex;
            }
            else if (cumulativeSum<0){
            	maxStartIndexUntilNow=currentIndex+1;
            	cumulativeSum=0;
            }
        }

        System.out.println("Max sum         : "+maxSum);
        System.out.println("Max start index : "+maxStartIndex);
        System.out.println("Max end index   : "+maxEndIndex);
    }
*/
