package com.algostudy;

import java.io.*;
import java.util.*;

public class Lie {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> party = new HashSet<Integer>();
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] find = new ArrayList[M];
		for (int i = 0; i < M; i++)
			find[i] = new ArrayList<Integer>();
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			int p = Integer.parseInt(st.nextToken());
			party.add(p);
		}
		for (int i = 0; i < M; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			boolean can = false;
			int temp_num = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				find[i].add(temp);
				if (party.contains(temp)) {
					can = true;
				}
			}
			if (can) {
				for (int j = 0; j < find[i].size(); j++)
					party.add(find[i].get(j));
			}
		}
		for (int e = 0; e < M; e++) {
			for (int i = 0; i < M; i++) {
				boolean can = false;
				for (int j = 0; j < find[i].size(); j++) {
					if (party.contains(find[i].get(j))) {
						can = true;
					}
				}
				if (can) {
					for (int j = 0; j < find[i].size(); j++)
						party.add(find[i].get(j));
				}
			}
		}
		int lie = 0;
		for (int i = 0; i < M; i++) {
			boolean can = false;
			for (int j = 0; j < find[i].size(); j++) {
				if (party.contains(find[i].get(j)))
					can = true;
			}
			if (can) {
				continue;
			} else 
				lie++;
		}
		System.out.println(lie);
	}
}
