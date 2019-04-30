package com.guobaoru.algorithm.sort.mergesort;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: guobaoru
 * @date: 2019/4/12 11:20
 */
public class MergeSort {

    public static void main(String[] args) {

        // 不计入算法 O（n）时间计算
        Integer[] arr = {1, 4, 6, 7, 9, 2, 3, 5, 8};

        // 排序
        mergeSort(arr);
    }

    /**
     * 排序
     *
     * @param arr
     */
    public static void mergeSort(Integer[] arr) {

        merge(arr);

        // 不计入算法 O（n）时间计算
        System.out.println(Arrays.asList(arr).toString());
    }


    public static void merge(Integer[] arr) {

        int mid = arr.length / 2;
        // 左指针
        int leftptr = 0;
        // 右指针
        int rightptr = mid + 1;
        // 新数组的起始指针
        int k = 0;

        Integer[] temp = new Integer[arr.length];

        while (leftptr < mid + 1 && rightptr < arr.length) {
            if (arr[leftptr] < arr[rightptr]) {
                temp[k] = arr[leftptr];
                leftptr++;
                k++;
            } else {
                temp[k] = arr[rightptr];
                rightptr++;
                k++;
            }
        }

        while (leftptr < mid + 1) temp[k++] = arr[leftptr++];
        while (rightptr < arr.length) temp[k++] = arr[rightptr++];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
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
