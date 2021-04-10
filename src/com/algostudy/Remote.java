package com.algostudy;

import java.io.*;
import java.util.*;

public class Remote {
	static int min = Integer.MAX_VALUE;
	static int count;
	static int channel;
	static List<Integer> button;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		channel = Integer.parseInt(in.readLine());
		int temp = channel;
		while (temp != 0) {
			temp /= 10;
			count++;
		}
		int M = Integer.parseInt(in.readLine());
		boolean[] b = new boolean[10];
		button = new ArrayList<Integer>();
		if (M != 0) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			while (st.hasMoreTokens()) {
				b[Integer.parseInt(st.nextToken())] = true;
			}
		}
		for (int i = 0; i < 10; i++)
			if (!b[i])
				button.add(i);
		min = Math.min(min, Math.abs(channel - 100));
		if (!button.isEmpty()) {
			if (button.contains(0))
				min = Math.min(min, channel + 1);
			for (int i = 0; i < 3; i++) {
				if (i + count - 1 > 0)
					control(0, new int[i + count - 1]);
			}
		}
		System.out.println(min);
	}

	static void control(int cnt, int[] num) {
		if (cnt == num.length) {
			if (num[0] == 0)
				return;
			int temp = 0;
			for (int i = 0; i < num.length; i++) {
				temp *= 10;
				temp += num[i];
			}
			min = Math.min(min, Math.abs(channel - temp) + cnt);
			return;
		}
		for (int i = 0; i < button.size(); i++) {
			num[cnt] = button.get(i);
			control(cnt + 1, num);
		}
	}

}
