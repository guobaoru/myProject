package com.guobaoru.algorithm.jianzhioffer;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/18.
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Algorithm1 {
    public static void main(String[] args) {
        int a[][]={{1,2,3},{4,5,6}};
        int b = 10;
        System.out.println(Find(b, a));
    }

    /**
     * 两种思路
     * 一种是：
     * 把每一行看成有序递增的数组，
     * 利用二分查找，
     * 通过遍历每一行得到答案，
     * 时间复杂度是nlogn
     *
     * 另外一种思路是：(示例方法)
     * 利用二维数组由上到下，由左到右递增的规律，
     * 那么选取右上角或者左下角的元素a[row][col]与target进行比较，
     * 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
     * 即col--；
     * 当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
     * 即row++；
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length-1;

        while (col >= 0 && row < array.length){
            if (array[row][col] > target){
                col--;
            }else if (array[row][col] < target){
                row++;
            }else {
                return true;
            }
        }
        return false;
    }

}
