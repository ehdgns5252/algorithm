package com.algostudy;

import java.io.*;
import java.util.*;

public class SubSequence {
	static int S;
	static int L;
	static int R;
	static int[] arr;
	static Map<Integer, Long> mapL = new HashMap<Integer, Long>();
	static Map<Integer, Long> mapR = new HashMap<Integer, Long>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		L = N / 2;
		R = N - L;
		arr = new int[N];
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] subL = new int[L];
		for (int i = 0; i < L; i++)
			subL[i] = arr[i];
		int[] subR = new int[R];
		for (int i = 0; i < R; i++)
			subR[i] = arr[i + L];
		sum(0, L, new boolean[L], subL, true);
		sum(0, R, new boolean[R], subR, false);
		long answer = isSame(S);
		if (S == 0 && answer > 0)
			answer--;
		System.out.println(answer);
	}

	static void sum(int cnt, int num, boolean[] isSelect, int[] sub, boolean isLeft) {
		if (cnt == num) {
			int temp = 0;
			for (int i = 0; i < num; i++) {
				if (isSelect[i]) {
					temp += sub[i];
				}
			}
			if (isLeft) {
				if (!mapL.containsKey(temp)) {
					mapL.put(temp, (long) 1);
				} else {
					mapL.put(temp, mapL.get(temp) + 1);
				}
			} else {
				if (!mapR.containsKey(temp)) {
					mapR.put(temp, (long) 1);
				} else {
					mapR.put(temp, mapR.get(temp) + 1);
				}
			}
			return;
		}
		isSelect[cnt] = true;
		sum(cnt + 1, num, isSelect, sub, isLeft);
		isSelect[cnt] = false;
		sum(cnt + 1, num, isSelect, sub, isLeft);
	}

	static long isSame(int S) {
		long temp = 0;
		if (mapL.isEmpty()) {
			for (int key : mapR.keySet()) {
				if (key == S) {
					return mapR.get(key);
				} else {
					return 0;
				}
			}
		}
//		L || R
//		S = L + R << 찾는경우
//		L -> mapL에 넣었고, R -> mapR
//		L + R = S인 R의 key를 찾음
		
		Set<Integer> tempL = mapL.keySet();
		Integer[] mapLeft = new Integer[tempL.size()];
		mapLeft = (Integer[]) tempL.toArray(mapLeft);
		for (int i = 0; i < mapLeft.length; i++) {
			if (mapR.containsKey(S - mapLeft[i]))
				temp += mapL.get(mapLeft[i]) * mapR.get(S - mapLeft[i]);
		}
		return temp;

	}
}
