package com.algorithm.ct;

import java.io.*;
import java.util.StringTokenizer;

public class Direct {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int max = Math.max(Math.abs(y2 - y1), Math.abs(x2 - x1));
			int gap = Math.abs(Math.abs(y2 - y1) - Math.abs(x2 - x1));
			int answer = max * 2 + (gap % 2 == 0 ? 0 : -1);
			System.out.println("#" + test + " " + answer);
		}
	}
}
