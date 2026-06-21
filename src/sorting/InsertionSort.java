package sorting;

public class InsertionSort {
    public static void main() {
        int[] arr = {1,5,3,6,8,2};

        int[] sortedArr = insertionSort(arr);

        for (int i : sortedArr){
            System.out.print(i + " ");
        }

    }
    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i += 1){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
