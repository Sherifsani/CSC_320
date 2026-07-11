package sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    public static List<Double> bucketSort(List<Double> arr){
        int n = arr.size();
        List<List<Double>> buckets = new ArrayList<>();

        // 1. Create the empty buckets
        for (int i = 0; i < n; i++){
            buckets.add(new ArrayList<>());
        }

        // 2. Scatter: Place elements into the correct buckets
        for (int i = 0; i < n; i++){
            // Multiply by 'n' to scale the decimal into our bucket range
            int bucketIndex = (int) (n * arr.get(i));
            buckets.get(bucketIndex).add(arr.get(i));
        }

        // 3. Sort individual buckets
        for (List<Double> bucket: buckets){
            bucket.sort(Double::compareTo);
        }

        // 4. Gather sorted elements
        List<Double> sortedArr = new ArrayList<>();
        for (List<Double> bucket: buckets){
            for(Double number: bucket){
                sortedArr.add(number);
            }
            // Alternatively, you can replace the inner loop with:
            // sortedArr.addAll(bucket);
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        List<Double> arr = new ArrayList<>();
        arr.add(0.42);
        arr.add(0.32);
        arr.add(0.23);
        arr.add(0.52);
        arr.add(0.25);
        arr.add(0.47);

        List<Double> sortedArr = bucketSort(arr);

        for (Double number: sortedArr){
            System.out.print(number + " ");
        }
    }
}