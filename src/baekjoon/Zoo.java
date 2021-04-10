package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Zoo {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] zoo = new int[N];
		boolean flag = true;
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp >= N)
				flag = false;
			else
				zoo[temp]++;
		}
		for (int i = 0; i < N; i++) {
			if (zoo[i] >= 3)
				flag = false;
		}
		if (flag) {
			int cnt = N;
			for (int i = 0; i < N; i++) {
				if (zoo[i] > 0) {
					zoo[i]--;
				} else {
					cnt = i;
					break;
				}
			}
			if (cnt == N) {
				System.out.println(2);
			} else {
				boolean is = true;
				for (int i = cnt; i < N; i++) {
					if (zoo[i] > 0) {
						is = false;
						break;
					}
				}
				if (!is)
					System.out.println(0);
				else {
					boolean isCan = true;
					for (int i = 0; i < N - cnt; i++) {
						if (zoo[i] != 1) {
							isCan = false;
							break;
						}
					}
					if (!isCan)
						System.out.println(0);
					else {
						int n = N - cnt;
						if (n == cnt)
						System.out.println((int) (Math.pow(2, n)));
						else
							System.out.println((int) (2 * Math.pow(2, n)));
					}
				}
			}
		} else {
			System.out.println(0);
		}
	}
}
