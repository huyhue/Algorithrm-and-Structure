package csd101;
import java.util.Scanner;
public class MyArray {
    int[] arr;
    int n;

    public static Scanner sc = new Scanner(System.in);
    public MyArray() {
    }

    public MyArray(int size) {
        arr = new int[size];
        n = size;
    }
    
    public void display(){
        System.out.println("================");
        //fori tab phim nhanh
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
    
    public void input(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter elements " + i + ": ");
            arr[i] = sc.nextInt();
        }
    }
    
    
    
}
