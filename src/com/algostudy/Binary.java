package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Binary {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		str = in.readLine();
		st = new StringTokenizer(str," ");
		int count = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0 && arr[i] == 1)
				count++;
			if (i != 0) {
				if (arr[i - 1] != arr[i] && arr[i] == 1)
					count++;
			}
		}
		for (int i = 0; i < M; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int info = Integer.parseInt(st.nextToken());
			if (info == 0)
				sb.append(count + "\n");
			if (info == 1) {
				int t = Integer.parseInt(st.nextToken());
				if (arr[t - 1] == 1) continue;
				else {
					arr[t - 1] = 1;
					if (t == N) {
						if (arr[N - 2] == 0)
							count++;        
					} else if (t == 1) {
						if (arr[1] == 0)
							count++;
					} else {
						if (arr[t - 2] == 0 && arr[t] == 0)
							count++;
						else if (arr[t - 2] == 1 && arr[t] == 1)
							count--;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
