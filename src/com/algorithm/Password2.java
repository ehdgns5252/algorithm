package com.algorithm;

import java.io.*;
import java.util.*;

public class Password2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			int N = Integer.parseInt(in.readLine());
			List<Integer> password = new ArrayList<Integer>();
			int i = 0;
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			while (st.hasMoreTokens())
				password.add(Integer.parseInt(st.nextToken()));
			int K = Integer.parseInt(in.readLine());
			str = in.readLine();
			st = new StringTokenizer(str, "I");
			for (i = 0; i < K; i++) {
				String s = st.nextToken();
				StringTokenizer st2 = new StringTokenizer(s, " ");
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				for (int j = 0; j < y; j++)
					password.add(x + j, Integer.parseInt(st2.nextToken()));
			}
			System.out.print("#" + test + " ");
			for (int j = 0; j < 10; j++)
				System.out.print(password.get(j) + " ");
			System.out.println();

		}
	}
}
