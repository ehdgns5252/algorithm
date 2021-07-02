package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] tri = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int idx = 0;
			while(st.hasMoreTokens()) {
				tri[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					tri[i][j] += tri[i - 1][j];
				else {
					tri[i][j] += Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
				}
				max = Math.max(tri[i][j], max);
			}
		}
		System.out.println(max);
	}
}
