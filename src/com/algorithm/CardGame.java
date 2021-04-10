package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class CardGame {
	static int[] gyu;
	static boolean[] use;
	static int[] yeong;
	static int win;
	static int lose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for (int test = 1; test <= N; test++) {
			win = 0;
			lose = 0;
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			use =  new boolean[19];
			gyu = new int[9];
			yeong = new int[9];
			for (int i = 0; i < 9; i++) 
				use[gyu[i] = Integer.parseInt(st.nextToken())] = true;
			int index = 0;
			for (int i = 1; i < 19; i++) {
				if (!use[i]) yeong[index++] = i;
			}
			isWin(0, new int[9], new boolean[9]);
			System.out.println("#" + test + " " + win + " " + lose);
		}
	}
	static public void isWin(int cnt, int[] card, boolean[] isVisit) {
		if (cnt == 9) {
			int gyuSum = 0;
			int yeongSum = 0;
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > card[i]) {
					gyuSum += gyu[i] + card[i];
				} else if (gyu[i] < card[i]) {
					yeongSum += gyu[i] + card[i];
				}
			}
			if (gyuSum > yeongSum) win++;
			else if (gyuSum < yeongSum) lose++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				card[cnt] = yeong[i];
				isWin(cnt + 1, card, isVisit);
				isVisit[i] = false;
			}
		}
	}
}
