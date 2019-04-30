package com.guobaoru.algorithm.sort.insertsort;

import java.util.Arrays;

/**
 * 插入排序
 * 把前面的值看做为已经排好的数组，依次往后循环取值插入之前的数组
 *
 * @Author: guobaoru
 * @Date: 2019/4/11 20:22
 * @Version 1.0
 */
public class insertSort {

    public static void main(String[] args) {

        // 不计入算法 O（n）时间计算
        Integer[] arr = {2, 4, 7, 1, 9, 3, 8, 5, 6};

        // 排序
        insertSort(arr);
    }

    /**
     * 排序
     *
     * @param arr
     */
    public static void insertSort(Integer[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j - 1);
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
