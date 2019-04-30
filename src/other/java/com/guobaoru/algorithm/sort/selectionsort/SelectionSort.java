package com.guobaoru.algorithm.sort.selectionsort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次循环选出最小的，放到第一位（与第一位交换位置）
 * 输出结果
 */
public class SelectionSort {

    /**
     * 不加收拾的常规逻辑
     * @param args
     */
    public static void main(String[] args) {

        Integer[] data = new Integer[]{10, 2, 8, 23, 5, 25, 75, 21, 3, 76, 12, 18};

        for (int i = 0; i < data.length; i++) {
            int min_index = -1;
            int min = 999999999;
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    min_index = j;
                    min = data[j];
                }
            }
            data[min_index] = data[i];
            data[i] = min;

        }

        System.out.println(Arrays.asList(data).toString());

    }
}
