package com.algorithm.IM;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumLine {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		List<Integer> temp = new ArrayList<Integer>();
		List<Integer> maxArr = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
//		if (N == 1) {
//			System.out.println(3);
//			System.out.println("1 1 0");
//			return ;
//		}
		for (int i = N; i >= N / 2; i--) {
			temp.add(N);
			temp.add(i);
			int t = N - i;
			while (t >= 0) {
				temp.add(t);
				t = temp.get(temp.size() - 2) - t;
			}
			if (temp.size() > max) {
				maxArr.clear();
				for (int x = 0; x < temp.size(); x++) 
					maxArr.add(temp.get(x));
				max = temp.size();
			} 
			temp.clear();
		}
		sb.append(max + "\n");
		for (int i = 0; i < maxArr.size(); i++)
			sb.append(maxArr.get(i) + " ");
		System.out.println(sb.toString());
	}
}
