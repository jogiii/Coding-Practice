package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseOrderTraversal {

    static ArrayList<Integer> levelOrder(Node node)
    {
        Queue<Node> queue = new LinkedList<Node>();

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> arr = new ArrayList<>();
        if(node == null)
            return null;

        queue.add(node);

        while(!queue.isEmpty()){

            Node tempNode=queue.poll();
            //arr.add(tempNode.data);
            stack.push(tempNode.data);

            if(tempNode.right!=null)
                queue.add(tempNode.right);

            if(tempNode.left!=null)
                queue.add(tempNode.left);



        }
        while(!stack.isEmpty()){
            arr.add(stack.pop());
        }
        return arr;
    }
}
