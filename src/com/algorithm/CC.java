package com.algorithm;

import java.io.*;
import java.util.*;

public class CC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] info = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					info[i][j] = Integer.parseInt(st.nextToken());
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Queue<Integer> q = new LinkedList<Integer>();
				q.offer(i);
				boolean[] isVisit = new boolean[N];
				isVisit[i] = true;
				int count = 0;
				int[] now = new int[N];
				now[i] = 0;
				while (!q.isEmpty()) {
					int temp = q.poll();
					boolean flag = true;
					for (int j = 0; j < N; j++) {
						if (info[temp][j] == 1 && !isVisit[j]) {
							isVisit[j] = true;
							count += now[temp] + 1;
							now[j] = now[temp] + 1;
							q.offer(j);
						}
						if (!isVisit[j])
							flag = false;
					}
					if (flag)
						break;
				}
				min = Math.min(min, count);
			}
			System.out.println("#" + test + " " + min);
		}
	}
}
