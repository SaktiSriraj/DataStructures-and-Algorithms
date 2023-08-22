public class HeightOfTree {
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

    public static int heightOfTree(Node root){
        if (root == null)
            return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int height = Math.max(leftHeight,rightHeight) + 1;
        return height ;
    }

    public static void main(String[] args){
        int[] nodes ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Height= "+ heightOfTree(root));
    }
}
