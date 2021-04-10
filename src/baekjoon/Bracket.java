package baekjoon;

import java.io.*;

public class Bracket {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int L = Integer.parseInt(in.readLine());
			if (L % 2 == 0) {
				int l = L / 2;
				long[] num = new long[l + 1];
				if (l > 2) {
					num[0] = 1;
					num[1] = 1;
					for (int i = 2; i <= l; i++) {
						for (int j = 0; j < i; j++)
							num[i] += (num[j] * num[i - j - 1]) % 1000000007;
						num[i] %= 1000000007;
					}
					System.out.println(num[l]);
				} else if (l == 2){
					num[0] = 1;
					num[1] = 1;
					num[2] = 2;
					System.out.println(num[l]);
				} else {
					System.out.println(1);
				}
			} else
				System.out.println(0);
		}
	}
}
