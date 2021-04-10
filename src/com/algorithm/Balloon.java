package com.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Balloon {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		ArrayList<int[]> info = new ArrayList<int[]>(); 
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 1; i < N + 1; i++)
			info.add(new int[] {i, Integer.parseInt(st.nextToken())});
		int num = 0;
		while (!info.isEmpty()) {
			if (info.size() == 1) {
				sb.append(info.remove(num)[0] + " ");
				break;
			}
			int[] temp = info.remove(num);
			if (temp[1] > 0) temp[1]--;
			num += temp[1];
			if (num < 0) num = info.size() + num % info.size();
			num %= info.size();
			sb.append((temp[0]) + " ");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
}
