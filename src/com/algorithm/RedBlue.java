package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class RedBlue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			int[] cir = new int[3];
			int[] rect = new int[4];
			String strC = in.readLine();
			String strR = in.readLine();
			StringTokenizer stC = new StringTokenizer(strC, " ");
			StringTokenizer stR = new StringTokenizer(strR, " ");
			int i = 0;
			while (stC.hasMoreTokens()) 
				cir[i++] = Integer.parseInt(stC.nextToken());
			i = 0;
			while (stR.hasMoreTokens()) 
				rect[i++] = Integer.parseInt(stR.nextToken());
			if (rect[0] <= cir[0] - cir[2] && rect[2] >= cir[0] + cir[2] && 
					rect[1] <= cir[1] - cir[2] && rect[3] >= cir[1] + cir[2]) {
				System.out.println("#" + test +" NY");
				continue;
			} else if(cir[2] * cir[2] >= (rect[0] - cir[0]) * (rect[0] - cir[0]) + (rect[1] - cir[1]) * (rect[1] - cir[1])
					&& cir[2] * cir[2] >= (rect[2] - cir[0]) * (rect[2] - cir[0]) + (rect[1] - cir[1]) * (rect[1] - cir[1])
					&& cir[2] * cir[2] >= (rect[0] - cir[0]) * (rect[0] - cir[0]) + (rect[3] - cir[1]) * (rect[3] - cir[1])
					&& cir[2] * cir[2] >= (rect[2] - cir[0]) * (rect[2] - cir[0]) + (rect[3] - cir[1]) * (rect[3] - cir[1])) {
				System.out.println("#" + test +" YN");
				continue;
			} else {
				System.out.println("#" + test +" YY");
				continue;
			}
		}
	}
}
