package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] atm = new int[N];
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++)
			atm[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(atm);
		int total = 0;
		int now = 0;
		for (int i = 0; i < N; i++) {
			now += atm[i];
			total += now;
		}
		System.out.println(total);
	}
}
