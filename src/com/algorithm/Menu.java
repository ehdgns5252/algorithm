package com.algorithm;

import java.io.*;
import java.util.*;

public class Menu {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] list = new String[N];
		for (int t = 0; t < N; t++) {
			String str = in.readLine();
			list[t] = str;
		}
		int M = Integer.parseInt(in.readLine());
		int[] course = new int[M];
		for (int i = 0; i < M; i++) {
			course[i] = Integer.parseInt(in.readLine());
		}
		Menu m = new Menu();
		Solution s = m.new Solution();
		String[] answer = s.solution(list, course);
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}

	class Solution {
		boolean[] arr;
		List<Character> list;
		int[] max;

		List<String>[] ans;
		public String[] solution(String[] orders, int[] course) {
	        List<String> menu = new ArrayList<String>();
	        String[] answer;
	        arr = new boolean[26];
	        list = new ArrayList<Character>();
	        max = new int[course.length];
	        ans = new List[course.length];
	        for (int i = 0; i < max.length; i++) {
	            max[i] = 2;
	            ans[i] = new ArrayList<String>();
	        }
	            
	        for (String s: orders) {
	            char[] str = s.toCharArray();
	            for (int i = 0; i < str.length; i++)
	                arr[str[i] - 'A'] = true;
	        }
	        for (int i = 0; i < 26; i++)
	            if (arr[i])
	                list.add((char) (i + 'A'));
	        for (int i = 0; i < course.length; i++) 
	            com(0, orders, 0, new char[course[i]], i);
	        for (int i = 0; i < course.length; i++) {
	        	if (!ans[i].isEmpty()) {
	        		for (int e = 0; e < ans[i].size(); e++)
	        			menu.add(ans[i].get(e));
	        	}
	        }
	        Set<String> temp = new LinkedHashSet<String>(menu);
	        menu = new ArrayList<String>(temp);
	        Collections.sort(menu);
	        answer = new String[menu.size()];
	        for (int i = 0; i < menu.size(); i++)
	        	answer[i] = menu.get(i);
	        return answer;
	    }

		void com(int cnt, String[] orders, int start, char[] menu, int index) {
	        if (cnt == menu.length) {
	            int num = 0;
	            for (int i = 0; i < orders.length; i++) {
	                char[] temp = orders[i].toCharArray();
	                boolean[] flag = new boolean[26];
	                int count = 0;
	                for (int j = 0; j < menu.length; j++) {
	                    flag[menu[j] - 'A'] = true;
	                }
	                for (int j = 0; j < temp.length; j++) 
	                    if(flag[temp[j] - 'A'])
	                        count++;
	                if (count == menu.length) 
	                    num++;
	            }
	            if (num > max[index]) {
	                max[index] = num;
	                ans[index].clear();
	                ans[index].add(new String(menu));
	            }
	            if (num == max[index]) {
	                ans[index].add(new String(menu));
	            }
	            return ;
	        }
	        for (int i = start; i < list.size(); i++) {
	            menu[cnt] = list.get(i);
	            com(cnt + 1, orders, i + 1, menu, index);
	        }
	    }
	}
}
