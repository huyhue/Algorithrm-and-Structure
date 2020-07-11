package LAB2;
public class Stack {

    public static void main(String[] args) {
        int[] b = {25, 17, 26, 19, 23};
        MyStack t = new MyStack(b.length);
        for (int i = 0; i < b.length; i++) {
            t.push(b[i]);
        }
        t.display();
        
        System.out.print("ÄrrayStack = ");
        for (int i = 0; i < b.length; i++) {
            System.out.print("  " + t.pop());
        }
        System.out.println();
        // This code is used for testing the result of Stack Lab 
        //Student should run these code and compare with your result 
        int x = 3;
        int y = 5;
        int z = 2;
        t.push(x);
        t.push(4);
        System.out.println("Top current: " + t.peek());
        t.pop();

        t.push(y);
        t.push(3);
        t.push(z);
        System.out.print("Traverse: ");
        t.traverse();
        t.pop();
        t.push(2);
        t.push(x);
        t.displayStack();
        
        while (!t.isEmpty()) {
            t.pop();
            t.displayStack();
        }
        t.displayStack();
//        t.convertBinary(2);
    }
}
