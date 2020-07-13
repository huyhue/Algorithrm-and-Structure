package myTree;
public class MyTree {
    TreeNode root;

    public MyTree() {
        this.root = null;
    }
    
    public MyTree(char rootValue) {
        this.root = new TreeNode(rootValue);
    }
    
    private void visit(TreeNode p){
        System.out.print((char)(p.info));
    }
    // inorder  traversal: left root right
    public void inOder(TreeNode node){
        if (node == null) {
            return;
        }
        inOder(node.left);
        visit(node);
        inOder(node.right);
    }
    // post order  traversal : left right root
    public void postOder(TreeNode node){
        if (node == null) {
            return;
        }
        postOder(node.left);
        postOder(node.right);
        visit(node);
    }
    
    // pre order traversal: root left right
    public void preOder(TreeNode node){
        if (node == null) {
            return;
        }
        visit(node);
        preOder(node.left);
        preOder(node.right);
    }
    
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }
    
    /* function to print level order traversal of tree*/
    void printLevelOrder() { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
    
    /* Print nodes at the given level */
    void printGivenLevel (TreeNode root ,int level) { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print((char)root.info + " "); 
        else if (level > 1){ 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
    
    void breadth(){
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }
    int count(TreeNode p){
        if (p==null) {
            return 0;
        }
        int k,h,r;
        k = count(p.left);
        h = count(p.right);
        r=k+h+1;
        return r;
    }
    
}
