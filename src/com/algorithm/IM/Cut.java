package com.algorithm.IM;

import java.io.*;
import java.util.*;

public class Cut {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		List<Integer> qX = new ArrayList<Integer>();
		List<Integer> qY = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(str, " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (p == 0)
				qY.add(n);
			else
				qX.add(n);
		}
		qY.add(0);
		qX.add(0);
		qY.add(y);
		qX.add(x);
		Collections.sort(qX);
		Collections.sort(qY);
		if (qY.size() == 2 && qX.size() == 2) {
			max = x * y;
		}
		else if (qY.size() == 2) {
			for (int i = 0; i < qX.size() - 1; i++) {
				int temp = (qX.get(i + 1) - qX.get(i)) * y;
				max = Math.max(temp, max);
			}
		} else if (qX.size() == 2) {
			for (int i = 0; i < qY.size() - 1; i++) {
				int temp = (qY.get(i + 1) - qY.get(i)) * x;
				max = Math.max(temp, max);
			}
		} else {
			for (int i = 0; i < qY.size() - 1; i++) {
				for (int j = 0; j < qX.size() - 1; j++) {
					int temp = (qY.get(i + 1) - qY.get(i)) * (qX.get(j + 1) - qX.get(j));
					max = Math.max(temp, max);
				}
			}
		}
		System.out.println(max);
	}
}
