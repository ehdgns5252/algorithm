package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Friend {
	static int[] money;
	static int[] friend;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		money = new int[N + 1];
		friend = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			friend[i] = i;
		}
		for (int i = 0; i < M; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (friend[i] == i)
				sum += money[i];
		}
		if (K >= sum)
			System.out.println(sum);
		else 
			System.out.println("Oh no");
	}
	static int parent(int a) {
		if (friend[a] == a) return a;
		return friend[a] = parent(friend[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = parent(a);
		int bRoot = parent(b);
		if (aRoot == bRoot) return false;
		if (money[aRoot] < money[bRoot]) friend[bRoot] = aRoot;
		else friend[aRoot] = bRoot;
		return true;
	}
}
