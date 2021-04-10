package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Seoro {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			StringBuilder sb = new StringBuilder();
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int[] parent = new int[N + 1];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			int M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int what = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (what == 0) {
					sum(a, b, parent);
				} else {
					if (include(a, b, parent))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			System.out.println("#" + test + " " + sb.toString());
		}
	}
	
	static public int find(int a, int[] parent) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a], parent);
	}
	
	static public boolean include(int a, int b, int[] parent) {
		a = find(a, parent);
		b = find(b, parent);
		if (a == b)
			return true;
		return false;
	}
	
	static public void sum(int a, int b, int[] parent) {
		if (!include(a, b, parent)) {
			parent[find(b, parent)] = parent[find(a, parent)];
		}
	}
}
