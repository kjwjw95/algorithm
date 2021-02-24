package com.backjun.gold;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기_1759 {
	static int L,C;
	static char[] pwd,ans;
	static boolean[] sel;
	static char[] moum= {'a','e','i','o','u'};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		L=sc.nextInt();
		C=sc.nextInt();
		pwd = new char[C];
		sel = new boolean[C];
		ans= new char[L];
		for(int i=0;i<C;i++) {
			pwd[i]=sc.next().charAt(0);
		}
		Arrays.sort(pwd);
		Combination(0,0);
	}
	public static void Combination(int idx,int cnt) {
		if(cnt==L) {
			int jaum=0,moums=0;
			for(int i=0;i<L;i++) {
				boolean isMo=false;
				for(int j=0;j<5;j++) {
					if(ans[i]==moum[j]) {
						isMo=true;
						moums++;
						break;
					}
				}
				if(!isMo)
					jaum++;
			}
			if(moums<1 || jaum<2)
				return;
			for(int i=0;i<L;i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
			return;
		}
		for(int i=idx;i<C;i++) {
			if(sel[i])	continue;
			ans[cnt]=pwd[i];
			sel[i]=true;
			Combination(i+1,cnt+1);
			sel[i]=false;
		}
	}
}
