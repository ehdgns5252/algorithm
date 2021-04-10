package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class CardGame1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int[] A = new int[5];
			int[] B = new int[5];
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++)
				A[Integer.parseInt(st.nextToken())]++;
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++)
				B[Integer.parseInt(st.nextToken())]++;
			boolean flag = false;
			for (int cnt = 4; cnt >= 0; cnt--) {
				if (A[cnt] > B[cnt]) {
					flag = false;
					System.out.println("A");
					break;
				}
				else if (B[cnt] > A[cnt]) {
					flag = false;
					System.out.println("B");
					break;
				}
				else {
					flag = true;
					continue;
				}
			}
			if (flag)
				System.out.println("D");
		}

	}
}
