/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd101;

import java.util.Scanner;

/**
 *
 * @author Quynh Tran Ly
 */
public class ListDemo {

    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
//        System.out.println("Enter size of array: ");
//        int size= in.nextInt();
//        MyArray marr= new MyArray(size);
//        marr.input();
//        marr.display();
        
//        System.out.println("Enter size of array list: ");
//        int size= in.nextInt();
//        MyArrayList marrl = new MyArrayList(size);
//        marrl.enterArrayList();
//        marrl.displayArrayList();

        System.out.print("Enter size of linklist list: ");
        int size = in.nextInt();
        MyLinkedList marrl = new MyLinkedList(size);
        marrl.enterLinkedList();
        marrl.enterFirst(12);
        marrl.enterLast(15);
        marrl.displayll();
        
        
    }

}
