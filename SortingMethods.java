import java.util.*;
/**
 * Write a description of class SortingMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortingMethods
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class SortingMethods
     */
    public SortingMethods()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static String selectionSort(int[] arr)
    {
        int lowIndex = 0;
        int temp;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i; j < arr.length; j++)
            {
                if(arr[j] < arr[lowIndex])
                {
                    lowIndex = j;
                }
            }
            temp = arr[lowIndex];
            arr[lowIndex] = arr[i];
            arr[i] = temp;
            //System.out.println(Arrays.toString(arr));
            lowIndex = i+1;
        }
        
        return Arrays.toString(arr);
    }
    public static String bubbleSort(int[] arr)
    {
        int temp;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return Arrays.toString(arr);
    }
    public static String insertionSort(int[] arr)
    {
        int temp;
        for(int i = 1; i < arr.length; i++)
        {
            for(int j = i-1; j > 0; j--)
            {
                if(arr[i] < arr[j])
                {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                else
                {
                    break;
                }
            }
        }
        return Arrays.toString(arr);
    }
    public static void test()
    {
        int[] a = {1, 643, -574, 2, 9, -6, 3, 0, 0, 0};
        int[] b = {};
        int[] c = {89, 89, 89, 9, 9, 6, 3, 0, 0};
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] e = {1, 0};
        System.out.println("The following are for Selection Sort");
        System.out.println(selectionSort(a));
        System.out.println(selectionSort(b));
        System.out.println(selectionSort(c));
        System.out.println(selectionSort(d));
        System.out.println(selectionSort(e));
        
        System.out.println("The following are for Insertion Sort");
        System.out.println(insertionSort(a));
        System.out.println(insertionSort(b));
        System.out.println(insertionSort(c));
        System.out.println(insertionSort(d));
        System.out.println(insertionSort(e));
        
        System.out.println("The following are for Bubble Sort");
        System.out.println(bubbleSort(a));
        System.out.println(bubbleSort(b));
        System.out.println(bubbleSort(c));
        System.out.println(bubbleSort(d));
        System.out.println(bubbleSort(e));
    }
}
