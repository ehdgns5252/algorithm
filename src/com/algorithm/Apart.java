package com.algorithm;

public class Apart {
	public static void main(String[] args) {
		int N = 8;
		int[] arr = new int[8];
		arr[0] = 2;
		arr[1] = 3;
		for (int i = 2; i < 8; i++)
			arr[i] = arr[i - 1] + arr[i - 2];
		System.out.println(arr[7]);
	}
}
