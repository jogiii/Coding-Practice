package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTravesing {

    static ArrayList <Integer> levelOrder(Node node)
    {
        Queue<Node> queue = new LinkedList<Node>();

        ArrayList<Integer> arr = new ArrayList<>();
        if(node == null)
            return null;

        queue.add(node);

        while(!queue.isEmpty()){

            Node tempNode=queue.poll();
            arr.add(tempNode.data);

            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);


        }
        return arr;
    }
}
