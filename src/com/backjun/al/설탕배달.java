package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 설탕배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int ans=0;
		while(true) {
			if(N%5==0) {
				ans+=N/5;
				break;
			}else if(N%3==0 && N!=3) {
				ans++;
				N-=3;
			}else if(N<0) {
				ans=-1;
				break;
			}else if(N==3){
				ans++;
				break;
			}else {
				ans++;
				N-=5;
			}
		}
		System.out.println(ans);
	}

}
