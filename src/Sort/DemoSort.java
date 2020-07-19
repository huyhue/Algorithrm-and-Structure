package Sort;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoSort {

    private static final Scanner scanner = new Scanner(System.in);

    static ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public static void EnterData() {
        employeeList.add(new Employee("A06", "Tran Ly", 7));
        employeeList.add(new Employee("A05", "Tran Quang", 7));
        employeeList.add(new Employee("A03", "Nguyen An", 7));
        employeeList.add(new Employee("A01", "Truong Phung", 5));
        employeeList.add(new Employee("A04", "Pham Thi Lam", 2));
        employeeList.add(new Employee("A02", "Do Trung Ton", 5));
    }

    public static int Menu() {
        System.out.println("1. Sort Selection by array");
        System.out.println("2. Sort Selection by object (ID)");
        System.out.println("3. Sort Insertion by array");
        System.out.println("4. Sort Insertion by object (ID)");
        System.out.println("5. Sort Bubble by array");
        System.out.println("6. Sort Bubble by object (ID)");
        System.out.println("7. Sort Quick by array");
        System.out.println("8. Sort Quick by object (ID)");
        System.out.println("9. Sort Merge by array");
        System.out.println("10. Sort Merge by object (ID)");
        System.out.println("11. Sort Heap by array");
        System.out.println("12. Sort Heap by object (ID)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        int choice;
        int arr[] = {5, 3, 1, 8, 3};
        int lengh = arr.length;
        int lenghList = employeeList.size();
        EnterData();
        while (true) {
            choice = Menu();
            switch (choice) {
                case 1:
                    SelectionSort.selectionSort(arr);
                    SelectionSort.printArray(arr);
                    break;
                case 2:
                    SelectionSort.selectionSortD(employeeList);
                    break;
                case 3:
                    InsertionSort.insertionSort(arr);
                    InsertionSort.printArray(arr);
                    break;
                case 4:
                    InsertionSort.insertionSort(employeeList);
                    break;
                case 5:
                    BubbleSort.bubbleSort(arr);
                    BubbleSort.printArray(arr);
                    break;
                case 6:
                    BubbleSort.bubbleSort(employeeList);
                    break;
                case 7:
                    QuickSort.quickSort(arr, 0, lengh - 1);
                    QuickSort.printArray(arr);
                    break;
                case 8:
                    QuickSort.quickSort(employeeList, 0, lenghList-1);  //chay chua duoc
                    QuickSort.printList(employeeList);
                    break;
                case 9:
                    MergeSort.mergeSort(arr);
                    MergeSort.printArray(arr);
                    break;
                case 10:
                    
                    break;
                case 11:
                    HeapSort.heapSort(arr);
                    HeapSort.printArray(arr);
                    break;
                case 12:
                    
                    break;
                default:
                    return;
            }
        }
    }

}
