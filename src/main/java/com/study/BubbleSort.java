package com.study;

/**
 * 冒泡排序
 *
 * @author kaizhang
 * @create 2018-06-28 16:53
 **/

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,6,8,0,4,3,9};

        for (int i = 0;i<arr.length;i++){
            //外层循环控制趟数
            System.out.println(arr[i]);
            for (int j = 0;j<arr.length-i-1;j++){
                //内层循环控制比较次数
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }


        System.out.println(arr);

    }
}
