import java.util.*;
/**
 * Write a description of class SortingMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorting
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class SortingMethods
     */
    public Sorting()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void selectionSort(int[] arr)
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
        
        //return Arrays.toString(arr);
    }
    public static void bubbleSort(int[] arr)
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
        //return Arrays.toString(arr);
    }
    public static void insertionSort(int[] arr)
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
        //return Arrays.toString(arr);
    }
    public static void mergeSort(int[] arr)
    {
        Arrays.toString(mergeSort(0, arr.length, arr));
        // return Arrays.toString(mergeSort(0, arr.length, arr));
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
        //{1, 643, -574, 2, 9, -6, 3, 0, 0, 0};
        //{};
        //{89, 89, 89, 9, 9, 6, 3, 0, 0};
        //{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //{1, 0};
        int[] a = {1, 643, -574, 2, 9, -6, 3, 0, 0, 0};;
        int[] b = {};
        int[] c = {89, 89, 89, 9, 9, 6, 3, 0, 0};
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] e = {1, 0};
        System.out.println("The following are for Selection Sort");
        selectionSort(a);
        selectionSort(b);
        selectionSort(c);
        selectionSort(d);
        selectionSort(e);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));
        
        
        int[] a1 = {1, 643, -574, 2, 9, -6, 3, 0, 0, 0};
        int[] b1 = {};
        int[] c1 = {89, 89, 89, 9, 9, 6, 3, 0, 0};
        int[] d1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] e1 = {1, 0};
        System.out.println("The following are for Insertion Sort");
        insertionSort(a1);
        insertionSort(b1);
        insertionSort(c1);
        insertionSort(d1);
        insertionSort(e1);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(c1));
        System.out.println(Arrays.toString(d1));
        System.out.println(Arrays.toString(e1));
        
        
        int[] a2 = {1, 643, -574, 2, 9, -6, 3, 0, 0, 0};
        int[] b2 = {};
        int[] c2 = {89, 89, 89, 9, 9, 6, 3, 0, 0};
        int[] d2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] e2 = {1, 0};
        System.out.println("The following are for Bubble Sort");
        bubbleSort(a2);
        bubbleSort(b2);
        bubbleSort(c2);
        bubbleSort(d2);
        bubbleSort(e2);
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(b2));
        System.out.println(Arrays.toString(c2));
        System.out.println(Arrays.toString(d2));
        System.out.println(Arrays.toString(e2));
        
        int[] a3 = {1, 643, -574, 2, 9, -6, 3, 0, 0, 0};
        int[] b3 = {};
        int[] c3 = {89, 89, 89, 9, 9, 6, 3, 0, 0};
        int[] d3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] e3 = {1, 0};
        System.out.println("The following are for Merge Sort");
        mergeSort(a3);
        mergeSort(b3);
        mergeSort(c3);
        mergeSort(d3);
        mergeSort(e3);
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(b3));
        System.out.println(Arrays.toString(c3));
        System.out.println(Arrays.toString(d3));
        System.out.println(Arrays.toString(e3));
    }
}
