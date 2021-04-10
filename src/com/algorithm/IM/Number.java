package com.algorithm.IM;

import java.io.*;
import java.util.*;

public class Number {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int max = Integer.MIN_VALUE;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		int[] arr = new int[N];
		List<Integer> plus = new ArrayList<Integer>();
		List<Integer> minus = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
		}
		if (N == 1) {
			System.out.println(1);
			return ;
		}
		for (int i = 0; i < N - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				minus.add(i);
				if (arr[i] > arr[i + 1]) {
					max = Math.max(max, plus.size());
					plus.clear();
				}
			}
			else if (arr[i] < arr[i + 1]) {
				plus.add(i);
				if (arr[i] < arr[i + 1]) {
					max = Math.max(max, minus.size());
					minus.clear();
				}
			} else {
				plus.add(i);
				minus.add(i);
			}
		}
		max = Math.max(max, minus.size());
		max = Math.max(max, plus.size());
		System.out.println(max + 1);
	}
}
