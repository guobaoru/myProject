package com.guobaoru.algorithm.sort.bubblesort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 依次比较相邻的两个值，将较大的值后移
 *
 * @Author: guobaoru
 * @Date: 2019/4/11 19:57
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {

        // 不计入算法 O（n）时间计算
        Integer[] arr = {2, 4, 7, 1, 9, 3, 8, 5, 6};

        // 排序
        bubbleSort(arr);
    }

    /**
     * 排序
     *
     * @param arr
     */
    public static void bubbleSort(Integer[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        // 不计入算法 O（n）时间计算
        System.out.println(Arrays.asList(arr).toString());
    }

    /**
     * 交换数组两个位置
     *
     * @param a
     * @param b
     */
    private static void swap(Integer[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
