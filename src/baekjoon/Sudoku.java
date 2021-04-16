package baekjoon;

import java.io.*;
import java.util.ArrayList;

public class Sudoku {
	static ArrayList<int[]> make = new ArrayList<int[]>();
	static boolean isCan = false;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] temp = in.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = temp[j] - '0';
				if (sudoku[i][j] == 0)
					make.add(new int[] { j, i });
			}
		}
		sudoku(0, sudoku);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(sudoku[i][j]);
			System.out.println();
		}
	}

	static void sudoku(int index, int[][] map) {
		if (index == make.size()) {
			isCan = canMake(map);
			return;
		}
		int x = make.get(index)[0];
		int y = make.get(index)[1];
		int[] canGo = makeNum(x, y, map);
		for (int i = 0; i < canGo.length; i++) {
			
			map[y][x] = canGo[i];
			if (can(x, y, map, canGo[i])) {
//				printMap(map);
//				System.out.println();
				sudoku(index + 1, map);
				if (isCan)
					return;
			}
			map[y][x] = 0;
		}
	}
	static void printMap(int[][] map) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	static int[] makeNum(int x, int y, int[][] map) {
		boolean[] is = new boolean[10];
		for (int i = 0; i < 9; i++) {
			is[map[i][x]] = true;
			is[map[y][i]] = true;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				is[map[i + y / 3 * 3][j + x / 3 * 3]] = true;
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			if (!is[i])
				arr.add(i);
		}
		int[] ans = new int[arr.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = arr.get(i);
		}
		return ans;
	}

	static boolean can(int x, int y, int[][] map, int num) {
		boolean[] is = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (i != y)
				is[map[i][x]] = true;
		}
		if (is[num])
			return false;
		is = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (i != x)
				is[map[y][i]] = true;
		}
		if (is[num])
			return false;
		is = new boolean[10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i + y / 3 * 3 != y && j + x / 3 * 3 != x)
					is[map[i + y / 3 * 3][j + x / 3 * 3]] = true;
			}
		}
		if (is[num])
			return false;
		return true;
	}

	static boolean canMake(int[][] map) {
		boolean[] is;
		for (int x = 0; x < 9; x++) {
			is = new boolean[10];
			for (int i = 0; i < 9; i++)
				is[map[i][x]] = true;
			for (int i = 1; i < 10; i++)
				if (!is[i])
					return false;
		}
		for (int y = 0; y < 9; y++) {
			is = new boolean[10];
			for (int i = 0; i < 9; i++)
				is[map[y][i]] = true;
			for (int i = 1; i < 10; i++)
				if (!is[i])
					return false;
		}
		for (int y = 0; y < 9; y += 3) {
			for (int x = 0; x < 9; x += 3) {
				is = new boolean[10];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						is[map[i + y / 3 * 3][j + x / 3 * 3]] = true;
					}
				}
				for (int i = 1; i < 10; i++)
					if (!is[i])
						return false;
			}
		}
		return true;
	}
}
