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
    public static int[] bubbleSort(int[] arr)
    {
        return null;
    }
    /*public static int[] insertionSort(int[] arr)
    {
        
        for(int i = 1; i < arr.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if
            }
        }
    }*/
    public static void test()
    {
        int[] a = {1, 643, -574, 2, 9, -6, 3, 0, 0, 0};
        int[] b = {};
        int[] c = {89, 89, 89, 9, 9, 6, 3, 0, 0};
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(selectionSort(a));
        System.out.println(selectionSort(b));
        System.out.println(selectionSort(c));
        System.out.println(selectionSort(d));
    }
}
