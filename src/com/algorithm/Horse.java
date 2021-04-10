package com.algorithm;

import java.io.*;
import java.util.*;

public class Horse {
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {-1, 1, 0, 0};
	static int[] horseX = {2, 1, -2, 2, -2, -1, 1, -1};
	static int[] horseY = {1, 2, 1, -1, -1, 2, -2, -2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		int[][][] direct = new int[H][W][K + 1];
		int[][] horse = new int[H][W];
		for (int i = 0; i < H; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < W; j++)
				map[i][j] = st.nextToken().charAt(0); 
		}
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] isVisit = new boolean[H][W][K + 1];
		q.offer(new int[] {0, 0});
		isVisit[0][0][0] = true;
		while (!q.isEmpty()) {
			boolean flag = false;
			int[] now = q.poll();
			for (int cnt = 0; cnt < 4; cnt++) {
				int x = now[0] + dirX[cnt];
				int y = now[1] + dirY[cnt];
				if (x < 0 || x >= W || y < 0 || y >= H)
					continue;
				if (!isVisit[y][x][horse[now[1]][now[0]]] && map[y][x] == '0') {
					isVisit[y][x][horse[now[1]][now[0]]] = true;
					direct[y][x][horse[now[1]][now[0]]] = direct[now[1]][now[0]][horse[now[1]][now[0]]] + 1;
					horse[y][x] = horse[now[1]][now[0]];
					q.offer(new int[] {x, y});
					if (x == W - 1 && y == H - 1)
						flag = true;
				}
			}
			for (int cnt = 0; cnt < 8; cnt++) {
				int x = now[0] + horseX[cnt];
				int y = now[1] + horseY[cnt];
				if (horse[now[1]][now[0]] >= K)
					break;
				if (x < 0 || x >= W || y < 0 || y>= H)
					continue;
				if (map[y][x] == '0' && !isVisit[y][x][horse[now[1]][now[0]] + 1]) {
					isVisit[y][x][horse[now[1]][now[0]] + 1] = true;
					direct[y][x][horse[now[1]][now[0]] + 1] = direct[now[1]][now[0]][horse[now[1]][now[0]]] + 1;
					horse[y][x] = horse[now[1]][now[0]] + 1;
					q.offer(new int[] {x, y});
					if (x == W - 1 && y == H - 1)
						flag = true;
				}
			}
			if (flag) {
				break;
			}
		}
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++)
//				System.out.print(direct[i][j]);
//			System.out.println();
//		}
		for (int i = 0; i < K + 1; i++) {
			System.out.print(direct[H - 1][W - 1][i] + " ");
		}
//		if (direct[H - 1][W - 1] == 0) 
//			System.out.println(-1);
//		else
//			System.out.println(direct[H - 1][W - 1]);
	}
}
