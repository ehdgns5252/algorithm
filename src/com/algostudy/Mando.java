package com.algostudy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mando {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		ArrayList<Integer> mando = new ArrayList<Integer>();
		ArrayList<Integer> money = new ArrayList<Integer>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n / c; i++) {
			mando.add(c);
			money.add(d);
		}
		for (int i = 0; i < m; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			int count = a / b;
			for (int t = 0; t < count; t++) {
				mando.add(c);
				money.add(d);
			}
		}
		int[] temp_mando = new int[mando.size()];
		int[] temp_money = new int[money.size()];
		for (int i = 0; i < temp_mando.length; i++) {
			temp_mando[i] = mando.get(i);
			temp_money[i] = money.get(i);
		}
		int[][] sum = new int[temp_mando.length][n + 1];
		for (int i = 0; i < temp_mando.length; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0) {
					if (j >= temp_mando[i])
						sum[i][j] = temp_money[i];
				} else {
					if (j - temp_mando[i] >= 0) {
						sum[i][j] = Math.max(sum[i - 1][j], sum[i - 1][j - temp_mando[i]] + temp_money[i]);
					} else
						sum[i][j] = sum[i - 1][j];
				}
			}
		}
		if (temp_mando.length == 0)
			System.out.println(0);
		else
			System.out.println(sum[temp_mando.length - 1][n]);
	}
}
