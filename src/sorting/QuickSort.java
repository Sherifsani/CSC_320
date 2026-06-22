package sorting;

public class QuickSort {
    public static int partition(int[] arr, int p, int r){
        int x = arr[r];   // pivot (last element)
        int i = p - 1;    // index of smaller element
        for(int j = p; j <= r-1; j++){
            if(arr[j] <= x){         // if current <= pivot
                i += 1;
                swap(arr, i, j);     // move smaller element to left
            }
        }
        swap(arr, i+1, r);           // place pivot in correct position
        return i + 1;                // return pivot index
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void quickSort(int[] arr, int p, int r){
        if (p < r){                         // base case: sub-array has > 1 element
            int q = partition(arr, p, r);   // partition and get pivot index
            quickSort(arr, p, q-1);         // sort left sub-array
            quickSort(arr, q+1, r);         // sort right sub-array
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2,10,8,9}; // test input
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i += 1){ // print sorted result
            System.out.print(arr[i] + " ");
        }
    }
}
