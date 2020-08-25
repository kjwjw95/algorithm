package com.backjun.al;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
	static int N, M,Ans;
	static ArrayList<Integer[]> chiken;
	static ArrayList<Integer[]> house;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<Integer[]>();
		chiken = new ArrayList<Integer[]>();
		Ans=0;
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					Integer[] a = { i, tmp };
					house.add(a);
				} else if (n == 2) {
					Integer[] a = { i, tmp };
					chiken.add(a);
				}
				tmp++;
			}
		}
		selected = new boolean[chiken.size()];
		Combination(0,0,0);
		System.out.println(Ans);
	}

	private static void Combination(int cnt,int idx,int flag) {
		if (cnt == M) {
			int sum=0;
			for(int i=0;i<house.size();i++) {
				int min=99999;
				for (int j = 0; j < chiken.size(); j++) {
					if(!selected[j])	continue;
					min=Math.min(min, Length(house.get(i), chiken.get(j)));
				}
				sum+=min;
			}
			if(Ans!=0)
				Ans=Math.min(Ans, sum);
			else
				Ans=sum;
			return;
		}

		for (int i = idx; i < chiken.size(); i++) {
			if ((flag&1<<i)!=0)
				continue;
			selected[i] = true;
			Combination(cnt + 1,i,flag|(1<<i));
			selected[i] = false;
		}
	}

	private static int Length(Integer[] house, Integer[] chiken) {
		return Math.abs(chiken[0]-house[0])+Math.abs(chiken[1]-house[1]);
	}

}
