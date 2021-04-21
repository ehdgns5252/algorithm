package com.algorithm;

import java.io.*;
import java.util.*;

public class Height {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			int can = 0;
			ArrayList<Integer>[] big = new ArrayList[N];
			ArrayList<Integer>[] small = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				big[i] = new ArrayList<Integer>();
				small[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				small[b].add(a);
				big[a].add(b);
			}
			for (int i = 0; i < N; i++) {
				int size_big = big[i].size();
				int size_small = small[i].size();
				Queue<Integer> big_q = new LinkedList<Integer>();
				Queue<Integer> small_q = new LinkedList<Integer>();
				boolean[] isCan = new boolean[N];
				for (int cnt = 0; cnt < size_big; cnt++) {
					isCan[big[i].get(cnt)] = true;
					big_q.add(big[i].get(cnt));
				}
				while (!big_q.isEmpty()) {
					int t = big_q.poll();
					int ts = big[t].size();
					for (int cnt = 0; cnt < ts; cnt++) {
						if (!isCan[big[t].get(cnt)]) {
							isCan[big[t].get(cnt)] = true;
							big_q.add(big[t].get(cnt));
						}
					}
				}
				for (int cnt = 0; cnt < size_small; cnt++) {
					isCan[small[i].get(cnt)] = true;
					small_q.add(small[i].get(cnt));
				}
				while (!small_q.isEmpty()) {
					int t = small_q.poll();
					int ts = small[t].size();
					for (int cnt = 0; cnt < ts; cnt++) {
						if (!isCan[small[t].get(cnt)]) {
							isCan[small[t].get(cnt)] = true;
							small_q.add(small[t].get(cnt));
						}
					}
				}
				int count = 0;
				for (int cnt = 0; cnt < N; cnt++) {
					if (isCan[cnt])
						count++;
				}
				if (count == N - 1)
					can++;
			}
			System.out.println("#" + test + " " + can);
		}
	}
}
