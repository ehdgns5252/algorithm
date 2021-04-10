package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Array3 {
	static int[][] arr;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int j = 0;
			while (st.hasMoreTokens())
				arr[i][j++] = Integer.parseInt(st.nextToken());
		}
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		while (st.hasMoreTokens()) {
			int r = Integer.parseInt(st.nextToken());
			switch (r) {
				case (1): {
					upDown();
					break;
				}
				case (2): {
					leftRight();
					break;
				}
				case (3): {
					right();
					break;
				}
				case (4): {
					left();
					break;
				}
				case (5): {
					clockWise();
					break;
				}
				case (6): {
					counterClockWise();
					break;
				}
				default: break;
			}	
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	static void upDown() {
		int[] temp = new int[M];
		int step = N / 2;
		for (int i = 0; i < step; i++) {
			for (int j = 0; j < M; j++) {
				temp[j] = arr[i][j];
				arr[i][j] = arr[N - 1 - i][j];
				arr[N - 1 - i][j] = temp[j];
			}
		}
	}
	static void leftRight() {
		int[] temp = new int[N];
		int step = M / 2;
		for (int i = 0; i < step; i++) {
			for (int j = 0; j < N; j++) {
				temp[j] = arr[j][i];
				arr[j][i] = arr[j][M - 1 -i];
				arr[j][M - 1 - i] = temp[j];
			}
		}
	}
	static void right() {
		int[][] temp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][i] = arr[i][j];
			}
		}
		int cnt = N;
		N = M;
		M = cnt;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				arr[i][j] = temp[i][j];
		}
		leftRight();
	}
	static void left() {
		int[][] temp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][i] = arr[i][j];
			}
		}
		int cnt = N;
		N = M;
		M = cnt;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				arr[i][j] = temp[i][j];
		}
		upDown();
	}
	static void clockWise() {
		int n = N / 2;
		int m = M / 2;
		int[][] temp = new int[n][m];
		int[][] temp1 = new int[n][m];
		int[][] temp2 = new int[n][m];
		int[][] temp3 = new int[n][m];
		int[][] temp4 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp1[i][j] = arr[i][j];
				temp2[i][j] = arr[i][m + j];
				temp3[i][j] = arr[n + i][m + j];
				temp4[i][j] = arr[n + i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = temp1[i][j];
				temp1[i][j] = temp4[i][j];
				temp4[i][j] = temp3[i][j];
				temp3[i][j] = temp2[i][j];
				temp2[i][j] = temp[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = temp1[i][j];
				arr[i][m + j] = temp2[i][j];
				arr[n + i][m + j] = temp3[i][j];
				arr[n + i][j] = temp4[i][j];
			}
		}
	}
	static void counterClockWise() {
		int n = N / 2;
		int m = M / 2;
		int[][] temp = new int[n][m];
		int[][] temp1 = new int[n][m];
		int[][] temp2 = new int[n][m];
		int[][] temp3 = new int[n][m];
		int[][] temp4 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp1[i][j] = arr[i][j];
				temp2[i][j] = arr[i][m + j];
				temp3[i][j] = arr[n + i][m + j];
				temp4[i][j] = arr[n + i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = temp1[i][j];
				temp1[i][j] = temp2[i][j];
				temp2[i][j] = temp3[i][j];
				temp3[i][j] = temp4[i][j];
				temp4[i][j] = temp[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = temp1[i][j];
				arr[i][m + j] = temp2[i][j];
				arr[n + i][m + j] = temp3[i][j];
				arr[n + i][j] = temp4[i][j];
			}
		}
	}
}
