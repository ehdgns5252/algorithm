package com.algostudy;

import java.io.*;
import java.util.*;

public class SumSl {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] sl = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			sl[i] = Integer.parseInt(st.nextToken());
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				answer += sl[i] * sl[j];
			}
		}
		System.out.println(answer);
	}
}
