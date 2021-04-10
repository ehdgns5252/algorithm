package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Oven {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int cook = Integer.parseInt(in.readLine());
		
		int cookH = cook / 60;
		int cookM = cook % 60;
		
		if (cookM + minute >= 60) {
			minute = cookM + minute - 60;
			if (hour + 1 + cookH >= 24) hour = hour + cookH - 23;
			else hour = hour + 1 + cookH;
		}
		else {
			minute = cookM + minute;
			if (hour + cookH >= 24) hour = hour + cookH - 24;
			else hour = hour + cookH;
		}
		System.out.println(hour + " " + minute);
	}
}
