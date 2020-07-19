package Sort;

import java.util.ArrayList;

public class InsertionSort {

    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort(ArrayList<Employee> employeeList) {
        int i, j;
        for (i = 0; i < employeeList.size(); i++) {
            Employee tmp = employeeList.get(i);
            j = i-1;
            while ((j >= 0) && (employeeList.get(j).getId().compareTo(tmp.getId()) > 0)) {
                employeeList.set(j+1, employeeList.get(j));
                j--;
            }
            employeeList.set(j+1, tmp);
        }
        employeeList.forEach((e) -> {
            System.out.println(e.toString());
        });
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printObject(ArrayList<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
    
}
