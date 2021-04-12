package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class PMDM {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		int[] calc = new int[4];
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < 4; i++)
			calc[i] = Integer.parseInt(st.nextToken());
		int[] c = new int[N - 1];
		int index = 0;
		while (true) {
			for (int j = 0; j < 4; j++) {
				if (calc[j] > 0) {
					calc[j]--;
					c[index++] = j;
				}
			}
			if (index == N - 1)
				break;
		}
		per(0, new int[N - 1], c, new boolean[N - 1], A);
		System.out.println(max);
		System.out.println(min);
	}
	static void per(int index, int[] num, int[] calc, boolean[] isVisit, int[] A) {
		if (index == calc.length) {
			int sum = A[0];
			for (int i = 0; i < calc.length; i++) {
				switch (num[i]) {
					case 0: {
						sum += A[i + 1];
					}
						break;
					case 1: {
						sum -= A[i + 1];
					}
						break;
					case 2: {
						sum *= A[i + 1];
					}
						break;
					case 3: {
						sum /= A[i + 1];
					}
						break;
					default:
						break;
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < calc.length; i++) {
			if (!isVisit[i]) {
				num[index] = calc[i];
				isVisit[i] = true;
				per(index + 1, num, calc, isVisit, A);
				isVisit[i] = false;
			}
		}
	}
}
