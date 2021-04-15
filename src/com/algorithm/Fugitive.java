package com.algorithm;

import java.io.*;
import java.util.*;

public class Fugitive {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static int[][] can = { { 1, 2, 5, 6 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 }, { 1, 3, 6, 7 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			int[][] isCan = new int[N][M];
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<int[]> q = new LinkedList<int[]>();
			isCan[R][C] = 1;
			q.offer(new int[] { C, R });
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.poll()[1];
				switch (map[y][x]) {
				case 1: {
					for (int cnt = 0; cnt < 4; cnt++) {
						int nx = x + dirX[cnt];
						int ny = y + dirY[cnt];
						if (nx < 0 || nx >= M || ny < 0 || ny >= N)
							continue;
						for (int can_cnt = 0; can_cnt < 4; can_cnt++) {
							if (isCan[ny][nx] == 0 && map[ny][nx] == can[cnt][can_cnt]) {
								isCan[ny][nx] = isCan[y][x] + 1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
					break;
				case 2: {
					for (int cnt = 0; cnt < 2; cnt++) {
						int nx = x + dirX[cnt];
						int ny = y + dirY[cnt];
						if (nx < 0 || nx >= M || ny < 0 || ny >= N)
							continue;
						for (int can_cnt = 0; can_cnt < 4; can_cnt++) {
							if (isCan[ny][nx] == 0 && map[ny][nx] == can[cnt][can_cnt]) {
								isCan[ny][nx] = isCan[y][x] + 1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
					break;
				case 3: {
					for (int cnt = 2; cnt < 4; cnt++) {
						int nx = x + dirX[cnt];
						int ny = y + dirY[cnt];
						if (nx < 0 || nx >= M || ny < 0 || ny >= N)
							continue;
						for (int can_cnt = 0; can_cnt < 4; can_cnt++) {
							if (isCan[ny][nx] == 0 && map[ny][nx] == can[cnt][can_cnt]) {
								isCan[ny][nx] = isCan[y][x] + 1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
					break;
				case 4: {
					int[] temp = { 0, 3 };
					for (int cnt = 0; cnt < 2; cnt++) {
						int nx = x + dirX[temp[cnt]];
						int ny = y + dirY[temp[cnt]];
						if (nx < 0 || nx >= M || ny < 0 || ny >= N)
							continue;
						for (int can_cnt = 0; can_cnt < 4; can_cnt++) {
							if (isCan[ny][nx] == 0 && map[ny][nx] == can[temp[cnt]][can_cnt]) {
								isCan[ny][nx] = isCan[y][x] + 1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
					break;
				case 5: {
					int[] temp = { 1, 3 };
					for (int cnt = 0; cnt < 2; cnt++) {
						int nx = x + dirX[temp[cnt]];
						int ny = y + dirY[temp[cnt]];
						if (nx < 0 || nx >= M || ny < 0 || ny >= N)
							continue;
						for (int can_cnt = 0; can_cnt < 4; can_cnt++) {
							if (isCan[ny][nx] == 0 && map[ny][nx] == can[temp[cnt]][can_cnt]) {
								isCan[ny][nx] = isCan[y][x] + 1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
					break;
				case 6: {
					int[] temp = { 1, 2 };
					for (int cnt = 0; cnt < 2; cnt++) {
						int nx = x + dirX[temp[cnt]];
						int ny = y + dirY[temp[cnt]];
						if (nx < 0 || nx >= M || ny < 0 || ny >= N)
							continue;
						for (int can_cnt = 0; can_cnt < 4; can_cnt++) {
							if (isCan[ny][nx] == 0 && map[ny][nx] == can[temp[cnt]][can_cnt]) {
								isCan[ny][nx] = isCan[y][x] + 1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
					break;
				case 7: {
					int[] temp = { 0, 2 };
					for (int cnt = 0; cnt < 2; cnt++) {
						int nx = x + dirX[temp[cnt]];
						int ny = y + dirY[temp[cnt]];
						if (nx < 0 || nx >= M || ny < 0 || ny >= N)
							continue;
						for (int can_cnt = 0; can_cnt < 4; can_cnt++) {
							if (isCan[ny][nx] == 0 && map[ny][nx] == can[temp[cnt]][can_cnt]) {
								isCan[ny][nx] = isCan[y][x] + 1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
					break;
				default:
					break;
				}
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (isCan[i][j] != 0 && isCan[i][j] <= L)
						count++;
				}
			}
			System.out.println("#" + test + " " + count);
		}
	}
}
