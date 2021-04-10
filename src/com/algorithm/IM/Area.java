package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Area {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[101][101];
		for (int i = 0; i < 4; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[] a = new int[2];
			int[] b = new int[2];
			a[0] = Integer.parseInt(st.nextToken());
			a[1] = Integer.parseInt(st.nextToken());
			b[0] = Integer.parseInt(st.nextToken());
			b[1] = Integer.parseInt(st.nextToken());
			for (int y = a[1]; y < b[1]; y++)
				for (int x = a[0]; x < b[0]; x++) 
					arr[y][x] = 1;
			
		}
		int count = 0;
		for (int y = 0; y < 101; y++)
			for (int x = 0; x < 101; x++)
				if (arr[y][x] == 1)
					count++;
		System.out.println(count);
	}
}
