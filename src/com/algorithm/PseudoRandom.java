package com.algorithm;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class PseudoRandom {
	static boolean[] flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			Stack<Integer> pseudo = new Stack<Integer>();
			long[] info = new long[4];
			int i = 0;
			while (st.hasMoreTokens()) {
				info[i++] = Integer.parseInt(st.nextToken());
			}
			flag = new boolean[(int)info[3]];
			pseudo.push((int) info[0]);
			while (true) {
				int temp = (int) ((pseudo.peek() * info[1] + info[2]) % info[3]);
				if (flag[temp]) {
					pseudo.push(temp);
					break;
				}
				pseudo.push(temp);
				flag[temp] = true;
			}
			int count = 0;
			int num = pseudo.pop();
			while (!pseudo.isEmpty()) {
				count++;
				if (pseudo.pop()== num) {
					break;
				}
			}
			System.out.println("#" + test + " " + count);
		}
	}
}
