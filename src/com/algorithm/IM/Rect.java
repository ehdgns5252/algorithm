package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Rect {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 0; test < 4; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[][] info1 = new int[4][2];
			int[][] info2 = new int[4][2];
			for (int i = 0; i < 2; i++) {
				info1[i * 2][0] = Integer.parseInt(st.nextToken());
				info1[i * 2][1] = Integer.parseInt(st.nextToken());
			}
			info1[1][0] = info1[2][0];
			info1[1][1] = info1[0][1];
			info1[3][0] = info1[0][0];
			info1[3][1] = info1[2][1];
			for (int i = 0; i < 2; i++) {
				info2[i * 2][0] = Integer.parseInt(st.nextToken());
				info2[i * 2][1] = Integer.parseInt(st.nextToken());
			}
			info2[1][0] = info2[2][0];
			info2[1][1] = info2[0][1];
			info2[3][0] = info2[0][0];
			info2[3][1] = info2[2][1];
			if (info2[0][0] > info1[2][0] || info2[0][1] > info1[2][1]) 
				System.out.println("d");
			else if (info1[0][0] > info2[2][0] || info1[0][1] > info2[2][1])
				System.out.println("d");
			else {
				if (info1[1][0] == info2[3][0] && info1[1][1] == info2[3][1])
					System.out.println("c");
				else if (info1[2][0] == info2[0][0] && info1[2][1] == info2[0][1])
					System.out.println("c");
				else if (info1[3][0] == info2[1][0] && info1[3][1] == info2[1][1])
					System.out.println("c");
				else if (info1[0][0] == info2[2][0] && info1[0][1] == info2[2][1])
					System.out.println("c");
				else {
					if (info1[0][1] == info2[2][1] && info2[0][0] <= info1[2][0] && info2[2][0] >= info1[0][0])
						System.out.println("b");
					else if (info1[2][0] == info2[0][0] && info2[0][1] <= info1[2][1] && info2[2][1] >= info1[0][1])
						System.out.println("b");
					else if (info1[2][1] == info2[0][1] && info2[2][0] <= info1[0][0] && info2[0][0] >= info1[2][0])
						System.out.println("b");
					else if (info1[0][0] == info2[2][0] && info2[2][1] <= info1[0][1] && info2[0][1] >= info1[2][1])
						System.out.println("b");
					else if (info2[0][1] == info1[2][1] && info1[0][0] <= info2[2][0] && info1[2][0] >= info2[0][0])
						System.out.println("b");
					else if (info2[2][0] == info1[0][0] && info1[0][1] <= info2[2][1] && info1[2][1] >= info2[0][1])
						System.out.println("b");
					else if (info2[2][1] == info1[0][1] && info1[2][0] <= info2[0][0] && info1[0][0] >= info2[2][0])
						System.out.println("b");
					else if (info2[0][0] == info1[2][0] && info1[2][1] <= info2[0][1] && info1[0][1] >= info2[2][1])
						System.out.println("b");
					else
						System.out.println("a");
				}
			}
		}
	}
}
