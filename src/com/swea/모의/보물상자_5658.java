package com.swea.모의;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

class 보물상자_5658 {
	static int N,K,Ans;
	static String input,Chest[];
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans=0;
			N=sc.nextInt();
			K=sc.nextInt();
			input=sc.next();
			input+=input;
			Chest = new String[N];
			for (int i = 0; i < input.length()/2; i++) {
				int slice=i+N/4;
				Chest[i]=input.substring(i, slice);
			}
			Arrays.sort(Chest,Collections.reverseOrder());
			int cnt=1;
			for (int i = 0; i < Chest.length-1; i++) {
				if(cnt==K) {
					Ans =Integer.parseInt(Chest[i],16);
					break;
				}
				if(Chest[i].equals(Chest[i+1]))
					continue;
				cnt++;
				if(i==Chest.length-2)
					Ans =Integer.parseInt(Chest[i+1],16);
			}
			System.out.println("#"+test_case+" "+Ans);
		}
	}
}
