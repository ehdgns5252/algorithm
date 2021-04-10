package com.algorithm;

import java.io.*;
import java.util.*;

import javax.naming.LimitExceededException;

public class Suffle {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(in.readLine());
			String[] card = new String[N];
			StringBuilder sb = new StringBuilder();
			Queue<String> odd = new LinkedList<String>();
			Queue<String> even = new LinkedList<String>();
			Queue<String> result = new LinkedList<String>();
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int i = 0;
			while (st.hasMoreTokens()) 
				card[i++] = st.nextToken();
			for (int cnt = 0; cnt < N; cnt++) {
				if (cnt < N / 2 + N % 2) 
					odd.offer(card[cnt]);
				else
					even.offer(card[cnt]);
			}
			while (!odd.isEmpty() && !even.isEmpty()) {
				result.offer(odd.poll());
				result.offer(even.poll());
			}
			if (!odd.isEmpty()) result.offer(odd.poll());
			while (!result.isEmpty()) {
				sb.append(result.poll());
				sb.append(" ");
			}
			System.out.println("#" + test + " " + sb.toString());
		}
		
		
	}
}
