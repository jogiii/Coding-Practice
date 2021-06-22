package trees;

import java.util.Stack;

public class FlattenTree {


    public void flatten(Node root){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node current_node = stack.pop();


            if(current_node.right!=null){
                stack.push(current_node.right);
            }

            if(current_node.left!=null){
                stack.push(current_node.left);
            }

            if(!stack.isEmpty()){
                current_node.right=stack.peek();
            }

            current_node.left=null;

        }

    }
}
