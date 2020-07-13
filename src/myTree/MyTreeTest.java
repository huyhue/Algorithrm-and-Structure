package myTree;
public class MyTreeTest {
    public static void main(String[] args) {
        //creating tree and all nodes
        MyTree myTree = new MyTree();
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');
        TreeNode nodeH = new TreeNode('H');
        TreeNode nodeI = new TreeNode('I');
        
        //setting up the tree
        myTree.root = nodeF;
        nodeF.left = nodeB;
        nodeF.right = nodeG;
        nodeB.left = nodeA;
        nodeB.right = nodeD;
        nodeD.left = nodeC;
        nodeD.right = nodeE;
        nodeG.right = nodeI;
        nodeI.left = nodeH;
        
        System.out.println("Breadth first");
        myTree.breadth();
        System.out.println("");
        
        System.out.println("Depth first");
        
        System.out.println("In oder");
        myTree.inOder(nodeF);
        System.out.println("");
        
        System.out.println("Post order");
        myTree.postOder(nodeF);
        System.out.println("");
        
        System.out.println("Pre order");
        myTree.preOder(nodeF);
        System.out.println("");
        
        System.out.println("Hight tree: " + myTree.height(myTree.root));
        myTree.printLevelOrder();
        System.out.println();
        System.out.println("Count: " + myTree.count(nodeF));
    }
}
