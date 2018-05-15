
import java.sql.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class sorting
{
	static int success = 1;
	static int failure = 0;
	static int return_value = success;
	static int sizeTestArray = 0;
	static int[] integerTestArray = new int[sizeTestArray];
	static Scanner keyboard = new Scanner(System.in);
	static int numberOfSorts = 1;
	static int numberOfPerformedSorts = 0;

	public static void main(String[] args)
	{
		System.out.println("Please select a choice.");
		System.out.println("1. Selection Sort");
		System.out.println("2. Bubble Sort");
		System.out.println("3. Exit");

		int choice = keyboard.nextInt();
		if(choice == 1)
		{
			testSort();
			System.out.println("Selection Sort");
			System.out.println("Here is the sorted array:");
			selectionSort(integerTestArray, integerTestArray.length);
			System.out.println(Arrays.toString(integerTestArray));
		}		
		else if(choice == 2)
		{
			testSort();
			System.out.println("Bubble Sort");
			System.out.println("Here is the sorted array:");
			bubbleSort(integerTestArray, integerTestArray.length);
			System.out.println(Arrays.toString(integerTestArray));
		}
		
		
		
	}
	public static void testSort()
	{
		System.out.println("What is the size of the array you wish to sort between 1 and 1000?");
		do{		
		try{
			sizeTestArray = keyboard.nextInt();
			integerTestArray = new int [sizeTestArray];
		if(sizeTestArray > 1000)
		{
			System.out.println("The size of the array is too big. Try again.");
		}
		if(sizeTestArray < 1)
		{
			System.out.println("The size of the array is too small. Try again.");
		}
		}
		catch (NegativeArraySizeException e)
		{
			System.out.println("The number is negative. Try again.");
		}
		}
		while(sizeTestArray > 1000 || sizeTestArray < 1);
				
		integerTestArray = new int [sizeTestArray];
		for(int i = 0; i < integerTestArray.length; i++)
		{
			integerTestArray[i] = (int)(Math.random() * (2 * sizeTestArray));
		}
		System.out.println(Arrays.toString(integerTestArray));
}
		public static int copyFromToIntegerArrays(int [] fromArray, int[] toArray, int sizeIntegerArray)
		{
			for(int i = 0; i < toArray.length; i++)
			{
				toArray[i] = fromArray[i];
			}
			if(toArray.length == sizeIntegerArray) 
				{
				return success;
				}
			else {
				return failure;
			}	
		}
		public static int[] swapIntegers(int[] array, int integerOne, int integerTwo)
		{
		     int temporary = array[integerOne];
		     array[integerOne] = array[integerTwo];
		     array[integerTwo] = temporary;
		     return array;
		}
	    public static int selectionSort(int[] integerArray, int sizeArray) {
	        for (int i = 0; i < sizeArray - 1; i++) {
	            int min = i;
	            for (int j = i + 1; j < sizeArray; j++) {
	                if (integerArray[j] < integerArray[min]) {
	                    min = j;
	                }
	            }
	            integerArray = swapIntegers(integerArray, min, i);
	        }
	        numberOfPerformedSorts++;
	        return success;
	    }
	    public static int bubbleSort(int [] integerArray, int sizeArray)
	    {
	    	for(int i = 0; i < sizeArray - 1; i++)
	    	{
	    		for(int j = 0; j < ((sizeArray - i) - 1); j++)
	    		{
	    			if (integerArray[j] > integerArray[j+1])
	    			{
	    				integerArray = swapIntegers(integerArray,i,j);
	    			}
	    		}
	    	}
	    	return success;	    	
	    }
}