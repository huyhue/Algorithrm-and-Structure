package Sort;

import java.util.ArrayList;

public class QuickSort {

    public static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static int partition(ArrayList<Employee> list, int left, int right) {
        int i = left, j = right;
        Employee pivot = list.get((left + right) / 2);
        while (i <= j) {
            while (list.get(i).getId().compareTo(pivot.getId()) < 0) {
                i++;
            }
            while (list.get(j).getId().compareTo(pivot.getId()) > 0) {
                j--;
            }
            if (i <= j) {
                Employee temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }
        return i;
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        } else {
            int partIndex = partition(arr, left, right);
            if (left < partIndex - 1) {
                quickSort(arr, left, partIndex - 1);
            }
            if (partIndex < right) {
                quickSort(arr, partIndex, right);
            }
        }
        
    }
    public static void quickSort(ArrayList<Employee> list, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int partIndex = partition(list, left, right);
            if (left < partIndex - 1) {
                quickSort(list, left, partIndex - 1);
            }
            if (partIndex < right) {
                quickSort(list, partIndex, right);
            }
        }
    }
    
    public static void printList(ArrayList<Employee> list) {
        for (Employee e : list) {
            System.out.println(e);
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
