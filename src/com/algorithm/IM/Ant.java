package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Ant {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(in.readLine());
		int antX = 0;
		int antY = 0;
		if (((t + p) / w) % 2 == 0)
			antX = (t + p) % w;
		else
			antX = w - (t + p) % w;
		if (((t + q) / h) % 2 == 0)
			antY = (t + q) % h;
		else
			antY = h - (t + q) % h;
		antX %= w;
		antY %= h;
		sb.append(antX);
		sb.append(" ");
		sb.append(antY);
		System.out.println(sb.toString());
	}
}
