package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Coin {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1 ; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[] info = new int[2];
			int i = 0;
			while (st.hasMoreTokens())
				info[i++] = Integer.parseInt(st.nextToken());
			int money = info[1];
			int[] coin = new int[info[0]];
			int[] have = new int[info[0]];
			for (i = 0; i < info[0]; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				while (st.hasMoreTokens()) {
					coin[i] = Integer.parseInt(st.nextToken());
					have[i] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int total = 0;
			int maxPrice = 0;
			int[] temp = new int[info[0]];
			for (i = 0; i < info[0] - 1; i++)
				temp[i] = have[i];
			if (money > 2 * coin[info[0] - 1]) {
				total = money;
				money = coin[info[0] - 1] * 2;
			}
			for (i = info[0] - 1; i >= 0; i--) {
				int change = money;
				int num = 0;
				int price = 0;
				for (int j = i; j >= 0; j--) {
					for (int e = 0; e < info[0] - 1; e++)
						have[e] = temp[e];
					if (change - coin[j] < 0) {
						continue;
					}
					if (have[j] == 1) 
						num--;
					change -= coin[j];
					price += coin[j];
					have[j] = 1;
					num++;
				}
				if (num > max) {
					int cnt = info[0] - 1;
					int is = 0;
					while (price != 0) {
						if (price / coin[cnt] != 0) 
							is++;
						price %= coin[cnt--];
					}
					if (num == is) {
						maxPrice = price; 
						max = num;
					}
				}
			}
			System.out.println("#" + test + " " + max + " " + (total - maxPrice));
		}
	}
}
