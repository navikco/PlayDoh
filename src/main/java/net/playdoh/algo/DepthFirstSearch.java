package net.playdoh.algo;

import net.playdoh.datastructures.Tree;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        Tree.Node node = new Tree.Node(6);
        node.insert(8);
        node.insert(3);
        node.insert(2);
        node.insert(4);
        node.insert(7);
        node.insert(9);
        node.insert(5);

        System.out.println("Tree:Height :::>>> " + depthFirstSearch.getHeight(node));
        System.out.println("Tree:NodeExist [7] :::>>> " + depthFirstSearch.nodeExist(node, 7));
        System.out.println("Tree:NodeExist [1] :::>>> " + depthFirstSearch.nodeExist(node, 1));

        List<Integer> sums = new ArrayList<>();
        depthFirstSearch.findSumByLevel(sums, node, 0);
        System.out.println("Tree:Sum by Level :::>>> ");
        sums.stream().forEach(sum -> System.out.print(sum + " "));
        depthFirstSearch.findAverageByLevel(sums);
        System.out.println("");
        System.out.println("Tree:Average by Level :::>>> ");
        sums.stream().forEach(sum -> System.out.print(sum + " "));

        System.out.println("");
        depthFirstSearch.reverse(node);
        node.inOrderTraversal();
    }

    public void findSumByLevel(List<Integer> sums, Tree.Node node, int i) {

        if (node == null) {
            return;
        } else {
            if (sums.size() > i) {
                sums.set(i, sums.get(i) + node.getData());
            } else {

                sums.add(i, node.getData());
            }
            i++;
        }
        findSumByLevel(sums, node.getLeft(), i);
        findSumByLevel(sums, node.getRight(), i);
    }

    private void findAverageByLevel(List<Integer> sums) {

        for (int i = 0; i < sums.size(); i++) {

            sums.set(i, sums.get(i) / 2);
        }
    }

    public int getHeight(Tree.Node node) {

        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean nodeExist(Tree.Node node, int num) {

        if (node == null) {
            return false;
        }

        boolean leftExist = nodeExist(node.getLeft(), num);
        boolean rightExist = nodeExist(node.getRight(), num);
        return node.getData() == num || leftExist || rightExist;
    }

    public void reverse(Tree.Node node) {

        if (node == null) {
            return;
        }

        reverse(node.getLeft());
        reverse(node.getRight());

        Tree.Node leftNode = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(leftNode);
    }
}