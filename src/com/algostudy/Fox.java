package com.algostudy;

import java.io.*;
import java.util.*;

public class Fox {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//1-3-4, 2, 5
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		boolean[][] isCon = new boolean[5][5];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken()) - 1;
			isCon[n][m] = true;
			isCon[m][n] = true;
		}
		boolean flag = true;
		for (int i = 0; i < 5; i++) {
			if (isCon[1][i])
				flag = false;
			if (isCon[4][i])
				flag = false;
		}
		if (!flag) {
			System.out.println("Woof-meow-tweet-squeek");
		} else {
			int[] n = {0, 2, 3};
			flag = true;
			for (int i = 0; i < 3; i++) {
				int count = 0;
				for (int j = 0; j < 3; j++) {
					if (isCon[n[i]][n[j]])
						count++;
				}
				if (count != 2)
					flag = false;
			}
			
			if (flag)
				System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
			else
				System.out.println("Woof-meow-tweet-squeek");
		}
	}
}
