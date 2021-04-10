package com.algostudy;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Queue<Integer> card = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) 
			card.offer(i);
		int num = 0;
		while (true) {
			num = card.poll();
			if (card.isEmpty()) break;
			card.offer(card.poll());
		}
		System.out.println(num);
	}
}
