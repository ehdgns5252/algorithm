package com.algorithm;

import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			int max = 0;
			int maxIndex = 0;
			int min = 100;
			int minIndex = 0;
			for (int j = 0; j < 100; j++) {
				box[j] = sc.nextInt();
				if (box[j] <= min) {
					min = box[j];
					minIndex = j;
				}
				if (box[j] >= max) {
					max = box[j];
					maxIndex = j;
				}
			}
			if (max - min <= 1) {
				System.out.println("#" + i + " " + (max - min));
				continue;
			}
			for (int e = 0; e < dump; e++) {
				max--;
				min++;
				box[maxIndex]--;
				box[minIndex]++;
				for (int j = 0; j < 100; j++) {
					if (box[j] <= min) {
						min = box[j];
						minIndex = j;
					}
					if (box[j] >= max) {
						max = box[j];
						maxIndex = j;
					}
				}
			}
			System.out.println("#" + i + " " + (max - min));
		}
	}
}
