package com.algostudy;

import java.io.*;
import java.util.*;

public class Special {
	static boolean[] isVisit;
	static List<Integer>[] arr;
	static int N;
	static int[] parent;
	static boolean flag;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new List[N + 1];
		isVisit = new boolean[N + 1];
		parent = new int[N + 1];
		check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int temp;
			arr[f].add(s);
			arr[s].add(f);
		}
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int[] temp = new int[N];
		for (int i = 0; i < N; i++)
			temp[i] = Integer.parseInt(st.nextToken());
		if (temp[0] != 1) {
			System.out.println(0);
			return;
		}
		dfs(1, 1, temp);
		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

	static void dfs(int x, int cnt, int[] num) {
		if (cnt == N) {
			flag = true;
			return;
		}
		check[x] = true;
		for (int i = 0; i < arr[x].size(); i++) {
			if (arr[x].get(i) == num[cnt] && !check[num[cnt]]) {
				arr[x].remove(i);
				dfs(num[cnt], cnt + 1, num);
				break;
			}
		}
	}
}
