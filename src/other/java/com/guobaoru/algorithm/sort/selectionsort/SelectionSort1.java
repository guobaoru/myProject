package com.guobaoru.algorithm.sort.selectionsort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次循环选出最小的，放到第一位（与第一位交换位置）
 * 输出结果
 *
 * @author guobaoru
 */
public class SelectionSort1 {

    /**
     * 细节调整
     * 1、内层循环从 i+1 开始
     * 2、外层循环可以写成 i < arr.length-1
     * 3、exchange 方法抽离
     * 4、最小值判断精简语句
     * 5、抽离打印数组的方法（写算法其实不应该用工具包，此处偷懒了）
     * <p>
     * <p>
     * 时间复杂度 O（n方） 空间复杂度(算法中额外的空间使用) O(1)
     *
     * @param args
     */
    public static void main(String[] args) {

        // 不计入算法 O（n）时间计算
        Integer[] arr = {2, 4, 7, 1, 9, 3, 8, 5, 6};

        // 排序
        sort(arr);

    }

    /**
     * 排序
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            // 最小值位置
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                // 执行 （n-1）+（n-2）+（n-3）... + 2 + 1 次； " 二分之n方减n " 所以时间复杂度是O（n方）
                minPos = (arr[j] < arr[minPos]) ? j : minPos;
            }
            swap(i, minPos, arr);
        }

        // 不计入算法 O（n）时间计算
        System.out.println(Arrays.asList(arr).toString());
    }

    /**
     * 交换数组两个位置
     *
     * @param start
     * @param minPos
     */
    private static void swap(int start, int minPos, Integer[] arr) {
        int temp = arr[start];
        arr[start] = arr[minPos];
        arr[minPos] = temp;
    }

}
