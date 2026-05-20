package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr){
        int n = arr.length;
        if (n < 2) return;

        int m = n / 2;
        int[] leftHalf = new int[m];
        int[] rightHalf = new int[n - m];

        for (int i = 0; i < m; i += 1){
            leftHalf[i] = arr[i];
        }

        for (int i = m; i < n; i += 1){
            rightHalf[i - m] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(arr, leftHalf, rightHalf);
    }

    public static void merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int n1 = leftHalf.length;
        int n2 = rightHalf.length;

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2){
            if(leftHalf[i] <= rightHalf[j]){
                arr[k] = leftHalf[i];
                i += 1;
            }else{
                arr[k] = rightHalf[j];
                j += 1;
            }
            k += 1;
        }

        while(i < n1){
            arr[k] = leftHalf[i];
            i += 1;
            k += 1;
        }

        while(j < n2){
            arr[k] = rightHalf[j];
            j += 1;
            k += 1;
        }
    }
}
