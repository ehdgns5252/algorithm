package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Room {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] stu = new int[7][2];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			stu[grade][gender]++;
		}
		int room = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				room += stu[i][j] / K;
				if (stu[i][j] % K != 0) room++;
			}
		}
		System.out.println(room);
	}
}
