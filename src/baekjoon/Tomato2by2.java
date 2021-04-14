package baekjoon;

import java.io.*;
import java.util.*;

public class Tomato2by2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int[] dirX = {0, 0, -1, 1};
		int[] dirY = {-1, 1, 0, 0};
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] day = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new int[] {j, i});
					day[i][j] = 1;
				}
			}
		}
		int total = 1;
		for (int i = 0; i < M * N; i++) {
			if (q.isEmpty()) break;
			int[] temp = q.poll();
			for (int cnt = 0; cnt < 4; cnt++) {
				int nx = temp[0] + dirX[cnt];
				int ny = temp[1] + dirY[cnt];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (day[ny][nx] == 0 && map[ny][nx] == 0) {
					map[ny][nx] = 1;
					day[ny][nx] = day[temp[1]][temp[0]] + 1;
					total = day[ny][nx];
					q.offer(new int[] {nx, ny});
				}
			}
		}
		boolean flag = true;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 0)
					flag = false;
		if (flag) {
			System.out.println(total - 1);
		} else {
			System.out.println(-1);
		}
	}
}
