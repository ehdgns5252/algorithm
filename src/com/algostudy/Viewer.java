package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Viewer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long num = 0;
		for (int i = 0; i < N; i++) {
			int yes = 1;
			if ((A[i] - B) <= 0) yes = 1;
			else {
				yes += (A[i] - B) / C;
				if ((A[i] - B) % C != 0)
					yes++;
			}
			num += yes;
		}
		System.out.println(num);
	}
}
