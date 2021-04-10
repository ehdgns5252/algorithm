package com.algorithm;

import java.io.*;
import java.util.*;

public class Graph {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(in.readLine());
		HashMap<Integer, Integer>[] info = new HashMap[V + 1];
		for (int i = 0; i < V + 1; i++)
				info[i] = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < E; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (!info[u].containsKey(v)) {
				info[u].put(v, w);
			} else {
				if (info[u].get(v) > w) {
					info[u].replace(v, w);
				}
			}
		}
		int[] s = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			if (info[start].containsKey(i))
				s[i] = info[start].get(i);
			else
				s[i] = 10000000;
		}
		boolean[] isVisit = new boolean[V + 1];
		isVisit[start] = true;
		int minNode = 0;
		for (int e = 1; e < V + 1; e++) {
			int min = 10000000;
			for (int i = 1; i < V + 1; i++) {
				if (isVisit[i]) continue;
				if (min > s[i]) {
					min = s[i];
					minNode = i;
				}
			}
			isVisit[minNode] = true;
			Set<Integer> set = info[minNode].keySet();
			ArrayList<Integer> temp = new ArrayList<Integer>(set);
			for (int i = 0; i < info[minNode].size(); i++) {
				if (!isVisit[temp.get(i)]) {
					int n = 10000000;
					if (info[minNode].containsKey(temp.get(i)))
						n = info[minNode].get(temp.get(i));
					if (s[temp.get(i)] > min + n)
						s[temp.get(i)] = min + n;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if (i == start)
				sb.append(0);
			else if (s[i] != 10000000)
				sb.append(s[i]);
			else
				sb.append("INF");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
