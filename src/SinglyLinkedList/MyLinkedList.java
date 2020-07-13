package SinglyLinkedList;
public class MyLinkedList {

    public Node head = null;
    public Node tail = null;

    public MyLinkedList() {
    }

    public MyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is emply");
        } else {
            Node p = head;
            while (p.next != null) {
                System.out.print(" " + p.data);
                p = p.next;
            }
            System.out.println();
        }
    }

    public void addFirst(int value) {
        Node p = new Node(value);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void addLast(int value) {
        Node p = new Node(value);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public void insertAfterPosition(int value, int position) {
        Node q = new Node(value);
        int pp = 1;
        // Chot p la vi tri ban dau de chay
        Node p = head;
        while (p != null && pp < position) {
            p = p.next;
            System.out.println("" + p.data);
            pp++;
        }
        // khi thoat khoi vong while, luc nay ta co
        // con tro dung o vi tri position, node dang o p
        // tiep tuc luu noi tiep theo
        Node tmp = p.next;
        p.next = q;
        q.next = tmp;
    }
    
    public void addMany(int[] a){
        int n, i;
        n = a.length;
        for (i = 0; i < a.length; i++) {
            addLast(a[i]);
        }
    }
    
    public int size(){
        Node p = head;
        int c = 0;
        while(p != null){
            c++;
            p = p.next;
        }
        return c;
    }
    
    public void insertPositionK(int x, int position){
        if (isEmpty()) {
            head = tail = new Node(x);
        }else{
            int count = 1;
            Node p = head;
            while (p != null && count < position) {                
                p = p.next;
                count++;
            }
            Node temp = p.next;
            p.next = new Node(x, temp);
        }
    }
    
    public void addAfterPositionK(int k, int c){
        Node p = new Node(c);
        if (k == -1) {
            addFirst(c);
            return;
        }
        int count = 0;
        Node p1 = head;
        while (p1 != null && count < k) {            
            p1 = p1.next;
            count++;
        }
        if (p1 != null && count < k) {
            addLast(c);
            return;
        }
        p.next = p1.next;
        p1.next = p;
    }

    public int deleteFirst() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }else{
            Node p = head;
            head = head.next;
            // khuc nay return p.data de biet node nao bi xoa
            return p.data;
        }
    }

    public int deleteLast() {
        // xem nhung truong hop dac biet
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }else{
            Node p = head;
            Node prevNodeq = new Node();
            
            while (p.next != null) {
                prevNodeq = p;
                p = p.next;
            }
            tail = prevNodeq;
            prevNodeq.next = null;
            return p.data;
        }
    }
    
    
    
    public Node search(int x){
        Node p = head;
        while (p != null && p.data != x) {            
            p = p.next;
        }
        return p;
    }

}
