package com.algostudy;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int start;
	int end;
	int value;

	Node(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
}

public class MakeBridge {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] isVisit;
	static int k;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		k = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !isVisit[i][j]) {
					makeIsland(j, i, k);
					k++;
				}
			}
		}
		per();
		if (min == 10000000)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static int[] parent;

	static void per() {
		boolean[][] flag = new boolean[k - 1][k - 1];
		int[][] sum = new int[k - 1][k - 1];
		parent = new int[k - 1];
		for (int i = 0; i < k - 1; i++)
			parent[i] = i;
		for (int i = 1; i < k; i++) {
			int now = i;
			for (int j = 1; j < k; j++) {
				int minLength = 10000000;
				if (j == i)
					continue;
				int next = j;
				int length = Math.max(N, M);
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < M; x++) {
						if (map[y][x] == now) {
							for (int l = 2; l < length; l++) {
								for (int cnt = 0; cnt < 4; cnt++) {
									if (find(x, y, 2, cnt, next))
										break;
									if (find(x, y, 1, cnt, 0)) {
										if (find(x, y, l + 1, cnt, next)) {
											flag[now - 1][next - 1] = true;
											minLength = Math.min(minLength, l);
										}
									}

								}
							}
						}
					}
				}
				if (flag[now - 1][next - 1])
					sum[now - 1][next - 1] = minLength;
				else
					sum[now - 1][next - 1] = 0;
			}

		}
		ArrayList<Node> arr = new ArrayList<Node>();
		for (int i = 0; i < k - 1; i++) {
			
			for (int j = 0; j < k - 1; j++) {
				arr.add(new Node(i, j, sum[i][j]));
			}
		}
		Collections.sort(arr);
		int sumL = 0;
		int count = 0;
		for (Node n : arr) {
			if (n.value != 0) {
				if (union(n.start, n.end)) {
					sumL += n.value;
					count++;
				}
			}
		}
		if (count == k - 2)
			min = sumL;
		else
			min = -1;
		return;
	}

	static int parent(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = parent(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = parent(a);
		int bRoot = parent(b);
		if (aRoot == bRoot)
			return false;
		parent[bRoot] = aRoot;
		return true;
	}

	static boolean find(int x, int y, int length, int cnt, int num) {
		boolean flag = false;
		int nx = x;
		int ny = y;
		for (int i = 0; i < length - 1; i++) {
			nx += dirX[cnt];
			ny += dirY[cnt];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				return flag;
			if (map[ny][nx] != 0 && num != 0) {
				return flag;
			}
		}
		nx += dirX[cnt];
		ny += dirY[cnt];
		if (nx < 0 || nx >= M || ny < 0 || ny >= N)
			return flag;
		if (length == 1) {
			if (map[ny][nx] == num)
				return true;
		} else if (map[ny][nx] == num)
			return true;
		return flag;
	}

	static void makeIsland(int x, int y, int k) {
		isVisit[y][x] = true;
		map[y][x] = k;
		for (int cnt = 0; cnt < 4; cnt++) {
			int nx = x + dirX[cnt];
			int ny = y + dirY[cnt];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;
			if (isVisit[ny][nx])
				continue;
			else if (map[ny][nx] != 0) {
				makeIsland(nx, ny, k);
			}
		}
	}
}
