import java.util.Arrays;
/**
 * Contains static sorting methods for Bubble, Selection, Insertion, & Merge sorts
 * And a mthod for testing them
 *
 * @author - Joe Huber
 * @version  - September 12, 2023
 */
public class Sorting{
    
    static long mComps = 0;
    static long mSwaps = 0;

    /**
     * Sorts an unsorted array of integers and prints how many comparisons and swaps it runs
     * @param  -  the unsorted array
     */
    public static void selectionSort(int[] arr) {
        int lowIndex = 0;
        int temp;
        long comps = 0;
        long swaps = 0;
        
        for (int i = 0; i < arr.length; i++) {
            comps++;
            
            for (int j = i; j < arr.length; j++) {
                comps++;
                if (arr[j] < arr[lowIndex]) {
                    lowIndex = j;
                }
                comps++;
            }
            
            //Swaps the lowest number with the current index, documents the swap,
            //and adjusts the low index
            mComps++;
            if(lowIndex != i) {
                temp = arr[lowIndex];
                arr[lowIndex] = arr[i];
                arr[i] = temp;
                swaps++;
            }
            lowIndex = i + 1;
        }
        
        System.out.print(", " + comps + ", " + swaps);
    }
    /**
     * Sorts an unsorted array of integers and prints how many comparisons and swaps it runs
     * @param  -  the unsorted array
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        boolean sorted = true;
        long comps = 0;
        long swaps = 0;
        
        for (int i = 0; i < arr.length; i++) {
            comps++;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comps++;
                if (arr[j] > arr[j + 1]) {
                    //Swaps the larger number with the lower one & documents the swap
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    sorted = false;
                }
                
                comps++;
            }
            mComps++;
            if(sorted)
            {
                break;
            }
            sorted = false;
        }
        
        System.out.print(", " + comps + ", " + swaps);
    }
    
    /**
     * Sorts an unsorted array of integers and prints how many comparisons and swaps it runs
     * @param  -  the unsorted array
     */
    public static void insertionSort(int[] arr) {
        int num = 0;
        int index = 0;
        long comps = 0;
        long swaps = 0;
        
        for (int i = 1; i < arr.length; i++) {
            comps++;
            num = arr[i];
            index = i - 1;
            
            while (index != -1 && arr[index] > num) {
                arr[index + 1] = arr[index];
                swaps++;
                index--;
            }
            
            arr[index + 1] = num;
            swaps++;
        }
        
        System.out.print(", " + comps + ", " + swaps / 3);
    }
    /**
     * Sorts an unsorted array of integers by calling the other mergeSort method
     * and prints how many comparisons and swaps it runs
     * @param  arr -  the unsorted array
     */
    public static void mergeSort(int[] arr) {
        mComps = 0;
        mSwaps = 0;
        
        mergeSort(0, arr.length - 1, arr);
        System.out.print(", " + mComps + ", " + mSwaps / 3);
    }
    /**
     * Sorts an unsorted array of integers 
     * @param  start - start index of what is being merged
     * @param  end - end index of what is being merged
     * @param  arr - the array which is being sorted
     */
    public static void mergeSort(int start, int end, int[] arr) {
        if (start >= end) {
            return;
        } else if (start + 1 == end) {
            mComps++;
            if(arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                mSwaps++;
                return;
            }
        }
         else {
            int mid = (start + end) / 2;
            
            mergeSort(start, mid, arr);
            mergeSort(mid + 1, end, arr);
            merge(start, mid, end, arr);
        }
    }
    /**
     * Sorts an unsorted array of integers 
     * @param  start - start index of what is being merged
     * @param  mid - middle index of what is being merged
     * @param  end - end index of what is being merged
     * @param  arr - the array which is being sorted
     */
    public static void merge(int start, int mid, int end, int[] arr) {
        int index = start;
        int index2 = mid + 1;
        int newArrIndex = 0;
        int[] newArr = new int[end - start + 1];
        
        //Merges the first parts of the arrays together, ends when one
        //array finishes getting merged
        while (index <= mid && index2 <= end) {
            if (arr[index] < arr[index2]) {
                newArr[newArrIndex] = arr[index];
                index++;
                mSwaps++;
            } else {
                newArr[newArrIndex] = arr[index2];
                index2++;
                mSwaps++;
            }
            
            newArrIndex++;
            mComps += 3;
        }
        
        //Adds the rest of the array into the new array
        while (index <= mid) {
            newArr[newArrIndex] = arr[index];
            index++;
            newArrIndex++;
            mSwaps++;
            mComps++;
        }
        
        while (index2 <= end) {
            newArr[newArrIndex] = arr[index2];
            index2++;
            newArrIndex++;
            mSwaps++;
            mComps++;
        }
        
        mComps += 2;
        for (int i = 0; i < newArr.length; i++) {
           arr[i + start] = newArr[i];
           mSwaps++;
           mComps++;
        }
        
        mComps++;
    }
    /**
     * Runs tests on all the previous methods
     */
    public static void test() {
        
        int[] a = {1, 643, -574, 2, 9, -6, 3, 0, 0, 0};
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
