package Sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static void selectionSortA(ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(min).compareTo(employees.get(j)) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                Employee temp = employees.get(min);
                employees.set(min, employees.get(i));
                employees.set(i, temp);
            }
        }
        employees.forEach((e) -> {
            System.out.println(e.toString());
        });
    }

    public static void selectionSortD(ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size() - 1; i++) {
            int max = i;
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(max).compareTo(employees.get(j)) < 0) {
                    max = j;
                }
            }
            if (max != i) {
                Employee temp = employees.get(max);
                employees.set(max, employees.get(i));
                employees.set(i, temp);
            }
        }
        employees.forEach((e) -> {
            System.out.println(e.toString());
        });
    }


    public static void selectionSort(int arr[]){
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
 
    public static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    public static void print(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
    

}
