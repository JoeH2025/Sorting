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
    public static String mergeSort(int[] arr)
    {
        return Arrays.toString(mergeSort(0, arr.length, arr));
    }
    public static int[] mergeSort(int start, int end, int[] arr)
    {
        if(start == end)
        {
            //System.out.println("a");
            return arr;
        }
        else
        {
            int mid = (start+end)/2;
            mergeSort(start, mid, arr);
            mergeSort(mid+1, end, arr);
            return merge(start, mid, end, arr);
        }
    }
    public static int[] merge(int start, int mid, int end, int[] arr)
    {
        //System.out.println("b");
        int index = start;
        int index2 = mid;
        int newArrIndex = 0;
        int[] newArr = new int[end-start+1];
        while(index < mid && index2 < end)
        {
            if(arr[index] > arr[index2])
            {
                newArr[newArrIndex] = arr[index];
                index++;
            }
            else
            {
                newArr[newArrIndex] = arr[index2];
                index2++;
            }
            newArrIndex++;
        }
        if(index2 < end)
        {
            for(int i = index2; i < end; i++)
            {
                newArr[i-start] = arr[i];
            }
        }
        else if(index < mid)
        {
            for(int i = index; i < mid; i++)
            {
                newArr[i-start] = arr[i];
            }
        }
        for(int i = 0; i < newArr.length-1; i++)
        {
            newArr[i] = arr[start + i];
        }
        //System.out.println("c");
        return arr;
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
        
        System.out.println("The following are for Merge Sort");
        System.out.println(mergeSort(a));
        System.out.println(mergeSort(b));
        System.out.println(mergeSort(c));
        System.out.println(mergeSort(d));
        System.out.println(mergeSort(e));
    }
}
