/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTree;

import java.util.Iterator;
import java.util.TreeSet;
public class TreeSet2 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>();
        set.add("HUY1");
        set.add("HUY2");
        set.add("HUY3");
        System.out.println("Traversing element");
        Iterator i = set.descendingIterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
