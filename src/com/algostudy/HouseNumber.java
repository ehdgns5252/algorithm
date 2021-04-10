package com.algostudy;

import java.io.*;
import java.util.*;

public class HouseNumber {
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {-1, 1, 0, 0};
	static int num = 0;
	static boolean[][] isVisit;
	static List<Integer> house = new ArrayList<Integer>();
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][N];
		isVisit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !isVisit[i][j]) {
					BFS(map, j, i);
					if (num != 0) house.add(num);
					num = 0;
				}
			}
		}
		Collections.sort(house);
		System.out.println(house.size());
		for (int i = 0; i < house.size(); i++)
			System.out.println(house.get(i));
	}
	static void BFS(char[][] map, int x, int y) {
		if (map[y][x] == '0') 
			return ;
		else num++;
		isVisit[y][x] = true;
		for (int cnt = 0; cnt < 4; cnt++) {
			if (x + dirX[cnt] < 0 || x + dirX[cnt] >= N || y + dirY[cnt] < 0 || y + dirY[cnt] >= N) continue;
			if (!isVisit[y + dirY[cnt]][x + dirX[cnt]]) {
				BFS(map, x + dirX[cnt], y + dirY[cnt]);
			}
		}
	}
}
