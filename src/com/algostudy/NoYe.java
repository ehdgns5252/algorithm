package com.algostudy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NoYe {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		int[] prof = new int[2];
		int[] sg = new int[2];
		ArrayList<int[]> stu = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 5) {
					prof[0] = j;
					prof[1] = i;
				} else if (map[i][j] == 2) {
					sg[0] = j;
					sg[1] = i;
				} else if (map[i][j] == 1) {
					stu.add(new int[] {j, i});
				}
			}
		}
		int l = (int)Math.pow(prof[0] - sg[0], 2) + (int) Math.pow(prof[1] - sg[1], 2);
		l = (int) Math.sqrt(l);
		if (l < 5)
			System.out.println(0);
		else {
			if (prof[0] == sg[0]) {
				int count = 0;
				for (int i = 0; i < stu.size(); i++) {
					int x = stu.get(i)[0];
					int y = stu.get(i)[1];
					if (x == sg[0] && sg[1] > prof[1]) {
						if (y > prof[1] && sg[1] > y)
							count++;
					} else if (x == sg[0] && sg[1] < prof[1]) {
						if (y > sg[1] && prof[1] > y)
							count++;
					}
				}
				if (count >=3)
					System.out.println(1);
				else
					System.out.println(0);
			} else if (prof[1] == sg[1]) {
				int count = 0;
				for (int i = 0; i < stu.size(); i++) {
					int x = stu.get(i)[0];
					int y = stu.get(i)[1];
					if (y == sg[1] && sg[0] > prof[0]) {
						if (x > prof[0] && sg[0] > x)
							count++;
					} else if (y == sg[1] && sg[0] < prof[0]) {
						if (x > sg[0] && prof[0] > x)
							count++;
					}
				}
				if (count >=3)
					System.out.println(1);
				else
					System.out.println(0);
			} else {
				int count = 0;
				if (sg[0] > prof[0]) {
					if (sg[1] > prof[1]) {
						for (int i = 0; i < stu.size(); i++) {
							int x = stu.get(i)[0];
							int y = stu.get(i)[1];
							if (y >= prof[1] && y <= sg[1] && x >= prof[0] && x <= sg[0])
								count++;
						}
					} else {
						for (int i = 0; i < stu.size(); i++) {
							int x = stu.get(i)[0];
							int y = stu.get(i)[1];
							if (y <= prof[1] && y >= sg[1] && x >= prof[0] && x <= sg[0])
								count++;
						}
					}
				} else {
					if (sg[1] > prof[1]) {
						for (int i = 0; i < stu.size(); i++) {
							int x = stu.get(i)[0];
							int y = stu.get(i)[1];
							if (y >= prof[1] && y <= sg[1] && x <= prof[0] && x >= sg[0])
								count++;
						}
					} else {
						for (int i = 0; i < stu.size(); i++) {
							int x = stu.get(i)[0];
							int y = stu.get(i)[1];
							if (y <= prof[1] && y >= sg[1] && x <= prof[0] && x >= sg[0])
								count++;
						}
					}
				}
				if (count >= 3)
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
	}
}
