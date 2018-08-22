package com.guobaoru.algorithm.tree.binaryTree;

//初始化一个二叉树
public class TreeFactory {
    public static BinaryTree getBinaryTree() {
        BinaryTree treeRoot = new BinaryTree(0);
        BinaryTree tree1 = new BinaryTree(1);
        BinaryTree tree2 = new BinaryTree(2);
        BinaryTree tree3 = new BinaryTree(3);
        BinaryTree tree4 = new BinaryTree(4);
        BinaryTree tree5 = new BinaryTree(5);
        BinaryTree tree6 = new BinaryTree(6);
        BinaryTree tree7 = new BinaryTree(7);
        BinaryTree tree8 = new BinaryTree(8);
        BinaryTree tree9 = new BinaryTree(9);
        treeRoot.leftNode = tree1;
        treeRoot.rightNode = tree2;
        tree1.leftNode = tree3;
        tree1.rightNode = tree4;
        tree2.leftNode = tree5;
        tree2.rightNode = tree6;
        tree3.leftNode = tree7;
        tree3.rightNode = tree8;
        tree4.leftNode = tree9;
        return treeRoot;
    }
}
