/*

Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.

For example, given the following tree and K of 20

    10
   /   \
 5      15
       /  \
     11    15
Return the nodes 5 and 15.

 */
package main.java;

import java.util.ArrayList;
import java.util.List;

public class SumOfNodes {

    private static int node1;
    private static int node2;
    private static List<Integer> list;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(11);
        root.right.right = new Node(15);

        if (findNodesInBST(root, 25)){
            System.out.println(node1 +" and "+ node2);
        }
        else
            System.out.println("Pair does not exist");
    }

    private static boolean findNodesInBST(Node root, int sum) {
        list = new ArrayList<>();
        treeToList(root);
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int pairSum = list.get(start) + list.get(end);
            if (pairSum == sum) {
                node1 = list.get(start);
                node2 = list.get(end);
                return true;
            }
            else  if (pairSum > sum)
                end--;
            else
                start++;
        }

        return false;
    }

    private static void treeToList(Node root) {
        if (root == null)
            return;
        treeToList(root.left);
        list.add(root.data);
        treeToList(root.right);
    }
}
