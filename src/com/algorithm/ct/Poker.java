package com.algorithm.ct;

import java.io.*;
import java.util.StringTokenizer;

public class Poker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String[] jokbo = {"Straight Flush", "Four of a Kind", "Full House", "Flush", "Straight", "Three of a kind",
				"Two pair", "One pair", "High card"};
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			String[] card = new String[5];
			for (int i = 0; i < 5; i++)
				card[i] = st.nextToken();
			boolean isFlush = false;
			boolean isStraight = false;
			int isOne = 0;
			int isThree = 0;
			int isFour = 0;
			int[] count = new int[14];
			int[] color = new int[4];
			for (int i = 0; i < 5; i++) {
				char kind = card[i].charAt(0);
				char rank = card[i].charAt(1);
				if (rank - '0' > 0 && rank - '0' < 10)
					count[rank - '0']++;
				else if (rank == 'A')
					count[1]++;
				else if (rank == 'T')
					count[10]++;
				else if (rank == 'J')
					count[11]++;
				else if (rank == 'Q')
					count[12]++;
				else if (rank == 'K')
					count[13]++;
				switch (kind) {
					case 'S':
						color[0]++;
						break;
					case 'D':
						color[1]++;
						break;
					case 'H':
						color[2]++;
						break;
					case 'C':
						color[3]++;
						break;
					default:
						break;
				}
			}
			for (int cnt = 1; cnt < 14; cnt++) {
				if (count[cnt] == 2) 
					isOne++;
				else if (count[cnt] == 3)
					isThree++;
				else if (count[cnt] >= 4)
					isFour++;
				else if (count[cnt] == 1){
					if (cnt <= 9) {
						boolean flag = true;
						for (int temp = 0; temp < 5; temp++) {
							if (count[temp + cnt] == 0)
								flag = false;
						}
						if (flag)
							isStraight = true;
					}
				}
			}
			for (int cnt = 0; cnt < 4; cnt++) {
				if (color[cnt] >= 5)
					isFlush = true;
			}
			System.out.print("#" + test + " ");
			if (isStraight && isFlush)
				System.out.println(jokbo[0]);
			else if (isStraight)
				System.out.println(jokbo[4]);
			else if (isFlush)
				System.out.println(jokbo[3]);
			else if (isOne == 2)
				System.out.println(jokbo[6]);
			else if (isOne == 1 && isThree == 1)
				System.out.println(jokbo[2]);
			else if (isThree == 1)
				System.out.println(jokbo[5]);
			else if (isFour == 1)
				System.out.println(jokbo[1]);
			else if (isOne == 1)
				System.out.println(jokbo[7]);
			else
				System.out.println(jokbo[8]);
		}
	}
}
