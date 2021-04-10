package com.algorithm;

public class ColorBar {
	public static void main(String[] args) {
		int N = 6;
		int[] arr = new int[6];
		arr[0] = 2;
		arr[1] = 5;
		for (int i = 2; i < 6; i++)
			arr[i] = 2 * arr[i - 1] + arr[i - 2];
		System.out.println(arr[5]);
	}
}
