/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd101;

import static csd101.MyArray.sc;
import java.util.ArrayList;

public class MyArrayList {
   ArrayList<Integer> myarrlist = new ArrayList<>();
   int n;
    
    public MyArrayList(int n) {
        this.n = n;
    }

    public void enterArrayList() {
        int value;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter elements: ");
            value = ListDemo.in.nextInt();
            myarrlist.add(value);
        }
    }

    public void displayArrayList() {
        //fore TAB
        for (Integer value : myarrlist) {
            System.out.println("" + value);
        }
    }
    
    
}
