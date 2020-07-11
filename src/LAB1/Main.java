package LAB1;

import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    //check user input a number integer 
    private static int checkInputInt() {

        //loop until user input correct 
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    private static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = checkInputInt();
        }
        return a;
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("hellllo");
    }

    private static void sortArrayByBubbleSort(int[] a) {
        System.out.print("Unsorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
    }
    
    private static void print(int[] a) { 
        System.out.print("Sorted array: "); 
        for (int i = 0; i < a.length; i++) { 
            System.out.print(a[i] + " "); 
        } 
    }
    
     public static void main(String[] args) { 
         int n = inputSizeOfArray(); 
         int[] a = inputValueOfArray(n); 
         sortArrayByBubbleSort(a); 
         print(a); 
     } 
}
