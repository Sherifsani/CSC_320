package sorting;

public class HeapSort {
    static void main(String[] args) {
        int[] arr = {1,2,4,5,9,3,6}; // test input
        heapSort(arr);                       // sort the array
        for(int i = 0; i < arr.length; i += 1){ // print sorted result
            System.out.print(arr[i] + " ");
        }
    }

    public static void maxHeapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;   // left child index
        int right = 2 * i + 2;  // right child index
        int greatest = i;       // assume root is largest

        if (left < n && arr[left] > arr[i]) {       // compare with left child
            greatest = left;
        }
        if (right < n && arr[right] > arr[greatest]) { // compare with right child
            greatest = right;
        }
        if (greatest != i) {                   // swap if root is not largest
            int temp = arr[i];
            arr[i] = arr[greatest];
            arr[greatest] = temp;
            maxHeapify(arr, n, greatest);      // recursively heapify affected subtree
        }
    }

    public static void heapSort(int[] arr){
        int n = arr.length;   // array length

        // build max heap from bottom-up
        for(int i = n / 2 - 1; i >= 0; i--){
            maxHeapify(arr, n, i);
        }

        // extract largest element and move it to the end
        for(int i = n - 1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            maxHeapify(arr, i, 0);
        }
    }
}
