import java.util.*;
public class SelectionSort {
    public static int sizeTestArray = 0;
    public static int[] integerTestArray;    //creating integerTestArray
    public static int[] integerOriginalArray;   // creating integerOriginalArray
    static int success = 1;
    static int failure = 0;
    static int return_value = success;
    static int numberOfSorts = 1;
    static int numberOfPerformedSorts = 0;
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        testSort();
        copyFromToIntegerArrays(integerTestArray, integerOriginalArray, sizeTestArray);

        System.out.println(" ");
        System.out.println("Press 1 for Selection Sort, 2 for Bubble Sort or 3 to exit");
        int userSelection = input.nextInt();

        if (userSelection == 1)
            return_value = selectionSort(integerTestArray, sizeTestArray);
        else if (userSelection == 2)
            System.out.println(bubbleSort(integerTestArray, sizeTestArray));
        else
            System.exit(0);

        System.out.println("");
        System.out.println("Here is the unsorted array: ");
        System.out.println(Arrays.toString(integerOriginalArray));
        System.out.println("");
        System.out.println("Here is the sorted array: ");
        System.out.println(Arrays.toString(integerTestArray));
        if(userSelection == 1)
            System.out.println("\n" + "Selection sort succeeded!");
        if(userSelection == 2)
            System.out.println("\n" + "Bubble sort succeeded!");
        //if(return_value = )
    }

    public static void testSort() {
        int numberOfSorts = 1;
        int numberOfPerformedSorts = 0;

        System.out.println("Enter the size of the array from 1 to 1,000: ");
        sizeTestArray = input.nextInt();    //user input
        if (sizeTestArray < 1 || sizeTestArray > 1000) {
            System.out.println("Incorrect array size chosen.");
            System.exit(0);
        }
        System.out.println("Size of array is: " + sizeTestArray);

        integerTestArray = new int[sizeTestArray];    //creating integerTestArray
        integerOriginalArray = new int[sizeTestArray];   // creating integerOriginalArray

        for (int i = 0; i < integerTestArray.length; i++) {   //filling array with random integers from a range of twice the array size
            integerTestArray[i] = (int) (Math.random() * (2 * sizeTestArray) + 1);
        }
        System.out.print("Array: ");
        for (int i : integerTestArray) {  // printing the array
            System.out.print(" " + i + " ");

        }
    }

    public static int copyFromToIntegerArrays(int[] fromArray, int[] toArray, int sizeIntegerArray) {
        toArray = fromArray.clone();
        integerOriginalArray = toArray;
        System.out.println(" ");
        if (toArray == fromArray)
            return success;
        else
            return failure;
    }

    public static int[] swapIntegers(int[] array, int integerOne, int integerTwo) {
        int temp = array[integerOne];
        array[integerOne] = array[integerTwo];
        array[integerTwo] = temp;
        return array;
    }

    public static int selectionSort(int[] integerArray, int sizeArray) {
        for (int i = 0; i < sizeArray; i++) {
            int min = i;
            for (int j = i; j < sizeArray; j++) {
                if (integerArray[j] < integerArray[min]) {
                    min = j;
                }
                if (j == sizeArray - 1)
                    integerArray = swapIntegers(integerArray, min, i);
            }
            integerArray = integerTestArray;
        }
        numberOfPerformedSorts++;   //incrementing numberOfPerformedSorts
        return success;
    }

    public static int bubbleSort(int[] integerArray, int sizeArray) {
        for (int i = 0; i < sizeArray - 1; i++) {
            for (int j = 0; j < ((sizeArray - i) - 1); j++) {
                if (integerArray[j] > integerArray[j + 1]) {
                    integerArray = swapIntegers(integerArray, j, j +1);
                }
            }
        }
        return success;
    }
}




