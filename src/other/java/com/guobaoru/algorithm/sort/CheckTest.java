package com.guobaoru.algorithm.sort;

import com.guobaoru.algorithm.sort.selectionsort.SelectionSort1;

import java.util.Arrays;
import java.util.Random;

/**
 * 验证排序算法正确性
 *
 * @author guobaoru
 */
public class CheckTest {

    public static void main(String[] args) {

        /**
         * 验证次数
         */
        int count = 20;

        for (int j = 0; j < count; j++) {

            /**
             * 构造随机数组
             */
            Integer[] arr = new Integer[10000];
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(100000);
            }

            /**
             * 复制出一份数组进行比对
             */
            Integer[] arr1 = arr.clone();

            /**
             * 使用Arrays工具 和 自己的算法进行排序
             */
            Arrays.sort(arr);
            SelectionSort1.sort(arr1);

            /**
             * 核对数据
             */
            boolean result = true;
            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].equals(arr1[i])) {
                    result = false;
                    break;
                }
            }

            /**
             * 输出结果
             */
            System.out.println(result);
        }

    }
}
