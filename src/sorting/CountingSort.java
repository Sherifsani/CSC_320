package sorting;

public class CountingSort {

    public static int[] countingSort(int[] arr) {
        // Good practice: handle empty arrays so the max calculation doesn't fail
        if (arr == null || arr.length == 0) {
            return arr;
        }

        // Integer.MIN_VALUE is the standard way to represent the lowest possible int
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] countArr = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }

        return sortedArr;
    }
}