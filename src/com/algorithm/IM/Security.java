package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Security {
	static int C;
	static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		int[][] info = new int[N][2];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		int[] dong = new int[2];
		dong[0] = Integer.parseInt(st.nextToken());
		dong[1] = Integer.parseInt(st.nextToken());

		int route = 0;
		for (int i = 0; i < N; i++) {
			switch (info[i][0]) {
			case 1: {
				int left = Integer.MAX_VALUE;
				int right = Integer.MAX_VALUE;
				switch (dong[0]) {
				case 1: {
					left = Math.abs(info[i][1] - dong[1]);
					break;
				}
				case 2: {
					left = dong[1] + info[i][1] + R;
					right = 2 * (R + C) - left;
					break;
				}
				case 3: {
					left = dong[1] + info[i][1];
					break;
				}
				case 4: {
					left = dong[1] + (C - info[i][1]);
					break;
				}
				default:
					break;
				}
				route += Math.min(left, right);
				break;
			}
			case 2: {
				int left = Integer.MAX_VALUE;
				int right = Integer.MAX_VALUE;
				switch (dong[0]) {
				case 1: {
					left = dong[1] + R + info[i][1];
					right = 2 * (R + C) - left;
					break;
				}
				case 2: {
					left = Math.abs(info[i][1] - dong[1]);
					break;
				}
				case 3: {
					left = R - dong[1] + info[i][1];
					break;
				}
				case 4: {
					left = (R - dong[1]) + (C - info[i][1]);
					break;
				}
				default:
					break;
				}
				route += Math.min(left, right);
				break;
			}
			case 3: {
				int left = Integer.MAX_VALUE;
				int right = Integer.MAX_VALUE;
				switch (dong[0]) {
				case 1: {
					left = dong[1] + info[i][1];
					break;
				}
				case 2: {
					left = R + dong[1] - info[i][1];
					break;
				}
				case 3: {
					left = Math.abs(dong[1] - info[i][1]);
					break;
				}
				case 4: {
					left = C + dong[1] + info[i][1];
					right = 2 * (R + C) - left;
					break;
				}
				default:
					break;
				}
				route += Math.min(left, right);
				break;
			}
			case 4: {
				int left = Integer.MAX_VALUE;
				int right = Integer.MAX_VALUE;
				switch (dong[0]) {
				case 1: {
					left = C - dong[1] + info[i][1];
					break;
				}
				case 2: {
					left = R - info[i][1] + C - dong[1];
					break;
				}
				case 3: {
					left = C + dong[1] + info[i][1];
					right = 2 * (R + C) - left;
					break;
				}
				case 4: {
					left = Math.abs(dong[1] - info[i][1]);
					break;
				}
				default:
					break;
				}
				route += Math.min(left, right);
				break;
			}
			default:
				break;
			}
		}
		System.out.println(route);
	}

}
