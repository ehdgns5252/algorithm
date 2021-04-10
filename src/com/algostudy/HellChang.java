package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class HellChang {
	static int N;
	static int count = 0;
	static int K;
	static int[] kcal;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kcal = new int[N];
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++)
			kcal[i] = Integer.parseInt(st.nextToken());
		per(0, new int[N], new boolean[N]);
		System.out.println(count);
	}
	static void per(int index, int[] num, boolean[] isVisit) {
		if (index == N) {
			boolean flag = true;
			int health = 500;
			for (int i = 0; i < N; i++) {
				health += num[i] - K;
				if (health < 500) {
					flag = false;
					break;
				}
			}
			if (flag)
				count++;
			return ;
		}
		for (int i = 0; i < N; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				num[index] = kcal[i];
				per(index + 1, num, isVisit);
				isVisit[i] = false;
			}
		}
	}
}
