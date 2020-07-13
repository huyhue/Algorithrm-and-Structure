package StackCollection;

import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> st = new Stack<String>();
        st.push("Huy");
        st.push("Thanh");
        st.push("Tuan");
        st.push("Quang");
        
        System.out.println("Stack: "+st);
//        System.out.println("Display stack");
//        Iterator value = st.iterator();
//        while (value.hasNext()) {
//            System.out.println("" + value.next());
//        }
        
        System.out.println("Stack pop() => " + st.pop());
        System.out.println("Stack current =>" + st);
        System.out.println("");
        System.out.println("Stack.peek()=> " + st.peek());//lay khong xoa
        System.out.println("Stack current =>" + st);
        
        System.out.println("------------------------");
        MyStack mst = new MyStack(4);
        mst.push("Huy");
        mst.push("Thanh");
        mst.push("Tuan");
        mst.push("Quang");
        
        System.out.println("Display my stack");
        System.out.println("" + mst.pop());
        System.out.println("" + mst.pop());
        System.out.println("" + mst.pop());
        System.out.println("" + mst.pop());
    }
}
