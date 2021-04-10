package com.algostudy;

import java.util.ArrayList;

public class Ex {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arr.add(i);
		}
		System.out.println(arr.size());
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < arr.size(); j++) {
				System.out.print(arr.get(j) + " ");
			}
			arr.remove(0);
			System.out.println(arr.size());
		}
	}
}
