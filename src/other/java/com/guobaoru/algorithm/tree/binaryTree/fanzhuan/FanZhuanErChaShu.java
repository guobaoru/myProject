package com.guobaoru.algorithm.tree.binaryTree.fanzhuan;

import com.guobaoru.algorithm.tree.binaryTree.BinaryTree;
import com.guobaoru.algorithm.tree.binaryTree.TreeFactory;
import com.guobaoru.algorithm.tree.binaryTree.bianli.Bianli;

//翻转二叉树
public class FanZhuanErChaShu {
    public static void Mirror(BinaryTree root) {
        if (root == null)
            return;
        if (root.leftNode == null && root.rightNode == null)
            return;
        BinaryTree pTemp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = pTemp;

        if (root.leftNode != null)
            Mirror(root.leftNode);
        if (root.rightNode != null)
            Mirror(root.rightNode);
    }
    public static void main(String[] args) {
        BinaryTree tree = TreeFactory.getBinaryTree();
        Bianli.preorder(tree);
        System.out.println();
        Mirror(tree);
        Bianli.preorder(tree);
    }
}
