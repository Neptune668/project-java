package com.atguigu.java.day1;

public class Demo_for {
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 40, 50};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j+1] > arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
