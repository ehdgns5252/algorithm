package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class WareHouse {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int max = 0;
		int maxIndex = 0;
		int start = 1001;
		int end = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] house = new int[1001];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			house[l] = h;
			if (max < h) {
				max = h;
				maxIndex = l;
			}
			if (start > l) 
				start = l;
			if (end < l) 
				end = l;
		}
		for (int i = start; i < maxIndex; i++) 
			if (house[i] > house[i + 1])
				house[i + 1] = house[i];
		for (int i = end; i > maxIndex; i--) 
			if (house[i] > house[i - 1])
				house[i - 1] = house[i];
		int sum = 0;
		for (int i = start; i <= end; i++) 
			sum += house[i];
		
		System.out.println(sum);
	}
}
