package com.algostudy;

import java.io.*;
import java.util.*;

public class MagicShark {
	static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<int[]> fire = new LinkedList<int[]>();
		for (int i = 0; i < M; i++) {
			int[] temp = new int[5];
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				if (j == 0 || j == 1)
					temp[j] = Integer.parseInt(st.nextToken()) - 1;
				else
					temp[j] = Integer.parseInt(st.nextToken());
			}
			fire.offer(temp);
		}
		for (int test = 0; test < K; test++) {
			ArrayList<int[]>[] count = new ArrayList[N * N];
			for (int i = 0; i < N * N; i++) {
				count[i] = new ArrayList<int[]>();
			}
			while (!fire.isEmpty()) {
				int[] temp = fire.poll();
				int nr = temp[0] + temp[3] * dirY[temp[4]];
				int nc = temp[1] + temp[3] * dirX[temp[4]];
				nr %= N;
				nc %= N;
				if (nr < 0)
					nr += N;
				if (nc < 0)
					nc += N;
				count[nr * N + nc].add(temp);
			}
			for (int i = 0; i < N * N; i++) {
				int r = i / N;
				int c = i % N;
				if (count[i].size() >= 2) {
					int[] temp = new int[5];
					boolean flag = true;
					int is = count[i].get(0)[4] % 2;
					for (int cnt = 0; cnt < count[i].size(); cnt++) {
						if (count[i].get(cnt)[4] % 2 != is)
							flag = false;
						temp[2] += count[i].get(cnt)[2];
						temp[3] += count[i].get(cnt)[3];
					}
					temp[2] /= 5;
					temp[3] /= count[i].size();
					temp[0] = r;
					temp[1] = c;
					if (temp[2] == 0)
						continue;
					if (flag) {
						for (int cnt = 0; cnt < 4; cnt++) {
							int[] add = new int[5];
							for (int e = 0; e < 5; e++)
								add[e] = temp[e];
							add[4] = cnt * 2;
							fire.offer(add);
						}
					} else {
						for (int cnt = 0; cnt < 4; cnt++) {
							int[] add = new int[5];
							for (int e = 0; e < 5; e++)
								add[e] = temp[e];
							add[4] = cnt * 2 + 1;
							fire.offer(add);
						}
					}
				} else if (count[i].size() == 1) {
					int[] temp = count[i].get(0);
					temp[0] = r;
					temp[1] = c;
					fire.offer(temp);
				}
			}
		}
		int weight = 0;
		while (!fire.isEmpty())
			weight += fire.poll()[2];
		System.out.println(weight);
	}
}
