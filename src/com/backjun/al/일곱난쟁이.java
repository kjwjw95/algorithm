package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
	static int[] answer = new int[7];
	static boolean findAnswer=false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		for (int i = 0; i < 9; i++) {
			dwarf[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(dwarf);
		Find(0,0,dwarf, new boolean[9]);
	}
	private static void Find(int cnt, int idx, int[] dwarf, boolean[] select) {
		if(findAnswer)
			return;
		if(cnt==7) {
			int ans=0;
			for (int i = 0; i < answer.length; i++) {
				ans+=answer[i];
			}
			if(ans==100) {
				for (int i = 0; i < answer.length; i++) {
					System.out.println(answer[i]);
				}
				findAnswer=true;
			}
			return;
		}
		for (int i = idx; i < dwarf.length; i++) {
			if(!select[i]) {
				select[i]=true;
				answer[cnt]=dwarf[i];
				Find(cnt+1, i+1, dwarf, select);
				select[i]=false;
			}
		}
	}
}
