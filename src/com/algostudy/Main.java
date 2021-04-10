package com.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시작하는 칸과 끝나는 칸도 포함해서 센다.
public class Main {
	public static int[][] graph, distance;
	public static boolean[][] drill;
	public static int[] mx = { -1, 1, 0, 0 }, my = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		distance = new int[N][M];
		drill = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] line = bf.readLine().toCharArray();

			for (int j = 0; j < M; j++) {
				graph[i][j] = line[j] - '0';
				distance[i][j] = Integer.MAX_VALUE;
			}

		}
		// 처리
		Queue<int[]> qu = new LinkedList<int[]>();
		distance[0][0] = 1;
		qu.offer(new int[] { 0, 0 });

		while (!qu.isEmpty()) {
			int x = qu.peek()[0], y = qu.poll()[1];

			// 종료조건
			if (x == N - 1 && y == M - 1)
				break;

			for (int i = 0; i < mx.length; i++) {
				int nx = x + mx[i], ny = y + my[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				else {
					if (graph[nx][ny] == 1) {
						if (!drill[x][y] && distance[nx][ny] > distance[x][y] + 1) {
							drill[nx][ny] = true;
							distance[nx][ny] = distance[x][y] + 1;
							qu.offer(new int[] { nx, ny });
						}
					} else {
						if (distance[nx][ny] > distance[x][y] + 1) {
							drill[nx][ny] = drill[x][y];
							distance[nx][ny] = distance[x][y] + 1;
							qu.offer(new int[] { nx, ny });
						} else if (drill[nx][ny] && !drill[x][y]) {
							drill[nx][ny] = drill[x][y];
							distance[nx][ny] = distance[x][y] + 1;
							qu.offer(new int[] { nx, ny });
						}
					}
				}

			}
		}

		System.out.println(distance[N - 1][M - 1] == Integer.MAX_VALUE ? -1 : distance[N - 1][M - 1]);

	}

}

