package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class SharkKing {
	static int[] dirX = { 0, 0, 1, -1 };
	static int[] dirY = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] shark = new int[M + 1][5];
		boolean[] isCan = new boolean[M + 1];
		for (int i = 1; i <= M; i++) {
			isCan[i] = true;
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (j == 0 || j == 1 || j == 3)
					shark[i][j] = temp - 1;
				else
					shark[i][j] = temp;
			}
			map[shark[i][0]][shark[i][1]] = i;
		}
		int sum = 0;
		for (int test = 0; test < C; test++) {
			int[][] next = new int[R][C];
			for (int i = 0; i < R; i++) {
				if (map[i][test] != 0) {
					isCan[map[i][test]] = false;
					sum += shark[map[i][test]][4];
					map[i][test] = 0;
					break;
				}
			}
			for (int s = 0; s < M + 1; s++) {
				if (!isCan[s])
					continue;
				move(shark[s], C, R);
				int ny = shark[s][0];
				int nx = shark[s][1];
				if (shark[next[ny][nx]][4] < shark[s][4]) {
					isCan[next[ny][nx]] = false;
					next[ny][nx] = s;
				} else
					isCan[s] = false;
			}
			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					map[r][c] = 0;
			for (int s = 0; s < M + 1; s++) {
				if (isCan[s]) {
					map[shark[s][0]][shark[s][1]] = s;
				}
			}

		}
		System.out.println(sum);
	}

	static void move(int[] s, int C, int R) {
		int nx = s[1] + s[2] * dirX[s[3]];
		int ny = s[0] + s[2] * dirY[s[3]];
		if (s[3] == 2) {
			int t = nx % (2 * (C - 1));
			if (t > C - 1) {
				t = 2 * (C - 1) - t;
				s[3] = 3;
			}
			nx = t;
		} else if (s[3] == 3) {
			int t = nx % (2 * (C - 1));
			if (t < 0)
				t += 2 * (C - 1);
			if (t > C - 1) {
				t = 2 * (C - 1) - t;
				s[3] = 2;
			}
			nx = t;
			
		} else if (s[3] == 1) {
			int t = ny % (2 * (R - 1));
			if (t > R - 1) {
				t = 2 * (R - 1) - t;
				s[3] = 0;
			}
			ny = t;
		} else if (s[3] == 0) {
			int t = ny % (2 * (R - 1));
			if (t < 0)
				t += 2 * (R - 1);
			if (t > R - 1) {
				t = 2 * (R - 1) - t;
				s[3] = 1;
			}
			ny = t;
		}
		s[1] = nx;
		s[0] = ny;
	}
}
