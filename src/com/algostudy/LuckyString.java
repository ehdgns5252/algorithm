package com.algostudy;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class LuckyString {
	static Set<String> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] S = in.readLine().toCharArray();
		int N = S.length;
		answer = new HashSet<String>();
		per(0, new int[N], new boolean[N], N, S);
		System.out.println(answer.size());
	}
	static void per(int index, int[] num, boolean[] isVisit, int N, char[] S) {
		if (index == N) {
			boolean flag = true;
			char[] temp = new char[N];
			for (int i = 0; i < N; i++)
				temp[i] = S[num[i]];
			for (int i = 0; i < N - 1; i++) {
				if (S[num[i]] == S[num[i + 1]])
					flag = false;
			}
			if (flag)
				answer.add(new String(temp));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				num[index] = i;
				per(index + 1, num, isVisit, N, S);
				isVisit[i] = false;
			}
		}
	}
}
