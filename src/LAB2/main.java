package LAB2;
public class main {
    public static void main(String[] args) {
        MyStack st = new MyStack(5);
        st.convertBinary(5);
        st.traverse();
        System.out.print("");
        System.out.println(""+st.pop());
    }
}
