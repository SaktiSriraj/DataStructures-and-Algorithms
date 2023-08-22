
public class CheckSubtree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class binaryTree{
        static int idx=-1;
        public Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1)
                return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
 

     public static boolean isIdentical(Node root,Node subRoot){
       if(subRoot == null && root == null){
           return true;
       }
       if(root == null || subRoot == null){
           return false;
       }
       if(root.data == subRoot.data){
           return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
       }
       return false;
   }


    public static boolean isSubtree(Node root, Node subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        if(isIdentical(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args){
        int[] nodes ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] nodes2 ={1,2,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        binaryTree tree = new binaryTree();
        binaryTree tree2 = new binaryTree();
        Node root = tree.buildTree(nodes);
        Node root2 = tree2.buildTree(nodes2);
        System.out.println("Is Subtree:"+isSubtree(root,root2));
    }
}
