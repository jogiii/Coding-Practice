package trees;

class Tree {
    // root of Tree
    Node root;

    Tree() {
        root = null;
    }

    void inOrder(Node node) {
        if (node == null)
            return;

        // traverse the left child
        inOrder(node.left);

        // traverse the root node
        System.out.print(node.data + "->");

        // traverse the right child
        inOrder(node.right);
    }

    static int height(Node node){

        if (node == null) return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }

    static int diameter(Node node){
        if(node == null) return 0;

        return height(node.left)+height(node.right)+1;
    }

    static Node mirrorify(Node root)
    {
        if (root == null)
        {
            return null;

        }

        // Create new mirror node from original tree node
        Node mirror = new Node(root.data);
        mirror.right = mirrorify(root.left);
        mirror.left = mirrorify(root.right);
        return mirror;
    }


    public static void main(String[] args) {

        // create an object of Tree
        Tree tree = new Tree();

        // create nodes of tree
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);

        // create child nodes of left child
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(19);

        System.out.println("print me"+height(tree.root));

        System.out.println(diameter(tree.root));

        System.out.println("In Order traversal");
        tree.inOrder(tree.root);

        System.out.println(" Mirror In Order traversal");
        tree.inOrder(mirrorify(tree.root));


    }
}