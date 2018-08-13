package com.guobaoru.algorithm.tree.binaryTree.depth;

import com.guobaoru.algorithm.tree.binaryTree.BinaryTree;
import com.guobaoru.algorithm.tree.binaryTree.TreeFactory;
//求二叉树最大深度
public class Depth {
    public static int TreeDepth(BinaryTree root) {
        if(root==null)
            return 0;
        if(root.leftNode==null&&root.rightNode==null)
            return 1;
        if(root.leftNode==null)
            return TreeDepth(root.rightNode)+1;
        if(root.rightNode==null)
            return TreeDepth(root.leftNode)+1;
        return max(TreeDepth(root.leftNode),TreeDepth(root.rightNode))+1;
    }

    public static int max(int a,int b){
        return a>b?a:b;
    }

    public static void main(String[] args) {
        System.out.println(TreeDepth(TreeFactory.getBinaryTree()));
    }
}
