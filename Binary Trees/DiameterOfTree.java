//Number of Node in the longest path betweeen any two Nodes.

public class DiameterOfTree {
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

    //O(n^2) Approach.
    public static int heightOfTree(Node root){
        if (root == null)
            return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int height = Math.max(leftHeight,rightHeight) + 1;
        return height ;
    }

    public static int diameter(Node root) {
        if(root == null) return 0;

        int d1 = diameter(root.left);
        int d2 = diameter(root.right);
        int d3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(Math.min(d1, d2), d3);
    }

    //O(n) approach
    static class TreeInfo{
        int height, diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameterOfTree(Node root) {
        if(root == null) return new TreeInfo(0,0);
        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);

        int myHeight = Math.max(left.height,right.height) + 1;
        
        int diameter1 = left.diameter;
        int diameter2 = right.diameter;
        int diameter3 = left.height + right.height + 1;

        int myDiameter = Math.max(Math.max(diameter1,diameter2),diameter3);
        
        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);
        return myInfo;
    }

    public static void main(String[] args){
        int[] nodes ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println("Diameter O(n^2) = "+ diameter(root));
        System.out.println("Diameter O(n) = "+ diameterOfTree(root).diameter);

    }
}
