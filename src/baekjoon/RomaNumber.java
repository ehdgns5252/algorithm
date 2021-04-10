package baekjoon;

import java.io.*;

public class RomaNumber {
	static boolean[] isNum;
	static int[] roma = {1, 5, 10, 50};
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		isNum = new boolean[50 * N + 1];
		com(0, new int[N], N, 0);
		System.out.println(count);
	}
	static void com(int index, int[] num, int N, int start) {
		if (index == N) {
			int n = 0;
			for (int i = 0; i < N; i++)
				n += num[i];
			if (!isNum[n]) {
				isNum[n] = true;
				count++;
			}
			return ;
		}
		for (int i = start; i < 4; i++) {
			num[index] = roma[i];
			com(index + 1, num, N, i);
		}
	}
}
