package com.algostudy;

import java.io.*;
import java.util.*;

public class Train999 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] train = new char[N][20];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < 20; j++)
				train[i][j] = '0';
		Set<String> fin = new HashSet<String>();
		for (int i = 0; i < M; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int cnt = Integer.parseInt(st.nextToken());
			switch (cnt) {
			case 1: {
				int num = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				train[num][x] = '1';
				break;
			}
			case 2: {
				int num = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				train[num][x] = '0';
				break;
			}
			case 3: {
				int num = Integer.parseInt(st.nextToken()) - 1;
				char temp = train[num][0];
				char t;
				for (int e = 1; e < 20; e++) {
					t = train[num][e];
					train[num][e] = temp;
					temp = t;
				}
				train[num][0] = '0';
				break;
			}
			case 4: {
				int num = Integer.parseInt(st.nextToken()) - 1;
				char temp = train[num][19];
				char t;
				for (int e = 18; e >= 0; e--) {
					t = train[num][e];
					train[num][e] = temp;
					temp = t;
				}
				train[num][19] = '0';
				break;
			}
			default:
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			fin.add(String.valueOf(train[i]));
		}
		System.out.println(fin.size());
	}
}
