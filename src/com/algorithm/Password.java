package com.algorithm;

import java.io.*;
import java.util.*;

public class Password {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> password = new LinkedList<Integer>();
		for (int test = 1; test <= 10; test++) {
			int T = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			while (st.hasMoreTokens()) {
				password.offer(Integer.parseInt(st.nextToken()));
			}
			int i = 1;
			while (true) {
				if (i > 5) i = 1;
				int first = password.poll() - i;
				if (first <= 0) {
					first = 0;
					password.offer(first);
					break;
				}
				password.offer(first);
				i++;
			}
			System.out.print("#" + T + " ");
			while (!password.isEmpty()) {
				System.out.print(password.poll() + " ");
			}
			System.out.println();
		}
	}
}
