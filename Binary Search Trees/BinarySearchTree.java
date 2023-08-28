import java.util.ArrayList;

public class BinarySearchTree{

    //Node class
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //insert function
    public static Node insert(Node root, int val){
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        
        return root;

    }

    //Inorder traversal: returns the tree in sorted fashion.
    //root.left -> root -> root.right
    public static void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //search in a BST
    //if root.data > val -> search in left subtree
    //if root.data < val -> search in right subtree
    public static boolean searchValue(Node root, int value){
        if(root==null) return false;
        if(root.data==value) return true;

        if(root.data > value)
            return searchValue(root.left, value);
        if(root.data < value)
            return searchValue(root.right, value);

        return false;
    }

    //delete a node in bst
    public static Node delete(Node root, int val){
        if(root.data > val)
            root.left = delete(root.left, val);
        else if(root.data < val)
            root.right = delete(root.right, val);
        else{
            //root.data == val
            //case1 : leaf node deletion
            if(root.left == null &&  root.right == null)
                return null;

            //case 2: parent node deletion having one child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            //case3: parent node deletion having two children
            Node inSuccessor = inSuccessor(root.right);
            root.data = inSuccessor.data;
            root.right = delete(root.right, inSuccessor.data);
        }
        return root;
    }
    //inorder Successor -> left-mose node in right subtree
    public static Node inSuccessor(Node root) {
        while (root.left != null)
            root = root.left;
        
        return root;
    }

    //Given a data range, find the values present in the BST withing the data range
    public static void printInRange(Node root, int X, int Y){
        if(root==null) return;
        if(root.data >= X && root.data <= Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        else if(root.data >= Y)
            printInRange(root.left, X, Y);
        else
            printInRange(root.right, X, Y);
    }

    //Print all the paths, starting from the root node and ending with a leaf node
    public static void rootToLeaf(Node root, ArrayList<Integer> paths) {
        if(root == null) return;

        paths.add(root.data);

        if(root.left == null && root.right == null)
            printPath(paths);
        rootToLeaf(root.left, paths);
        rootToLeaf(root.right, paths);
        paths.remove(paths.size() - 1);
    }

    public static void printPath(ArrayList<Integer> paths){
        for(int i=0; i<paths.size(); i++){
            System.out.print(paths.get(i) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args){
       int val[] = {8,5,3,6,10,11,14};

        Node root = null;

        for(int i=0; i<val.length; i++){
            root = insert(root, val[i]);
        }
        inOrder(root);
        System.out.println();

        System.out.println(searchValue(root, 1));
        System.out.println();

        delete(root,5);
        inOrder(root);
        System.out.println();

        printInRange(root, 6, 10);
        System.out.println();

        System.out.println("Root to Leaf Paths:");
        rootToLeaf(root, new ArrayList<>());
    }
}