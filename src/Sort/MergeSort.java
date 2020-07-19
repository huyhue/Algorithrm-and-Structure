package Sort;

import java.util.ArrayList;

public class MergeSort {

    public static void merge(int left[], int right[], int arr[]) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0;
        int k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[]) {
        int nA = arr.length;
        if (nA < 2) {
            return;
        }
        int mid = nA / 2;
        int[] left = new int[mid];
        int[] right = new int[nA - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = mid; j < nA; j++) {
            right[j - mid] = arr[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }
    public static void mergeSort(ArrayList<Employee> list) {
        int nA = list.size();
        if (nA < 2) {
            return;
        }
        int mid = nA / 2;
        ArrayList<Employee> left = null;
        ArrayList<Employee> right = null;
        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }
        for (int j = mid; j < nA; j++) {
            right.add(list.get(j));
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, list);
        list.forEach((e) -> {
            System.out.println(e.toString());
        });
    }
    public static void merge(ArrayList<Employee> left, ArrayList<Employee> right, ArrayList<Employee> list) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0;
        int k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
