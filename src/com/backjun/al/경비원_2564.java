package com.backjun.al;

import java.util.Scanner;

public class 경비원_2564 {
	static int R;
	static int C;
	static int N;
	static class Store{
		int r,c,dir;// 북남서동

		public Store(int dir, int distance) {
			super();
			if(dir==1)
				this.r=0;
			else if(dir==2)
				this.r=R;
			else
				this.r=distance;
			
			if(dir==3)
				this.c=0;
			else if(dir==4)
				this.c=C;
			else
				this.c=distance;
			this.dir=dir;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C=sc.nextInt();
		R=sc.nextInt();
		N = sc.nextInt();
		Store[] stores = new Store[N+1];
		for (int i = 0; i < stores.length; i++) {
			stores[i]= new Store(sc.nextInt(), sc.nextInt());
		}
		int answer=0;
		for (int i = 0; i < N; i++) {
			answer+=Calcul(stores[i],stores[N]);
		}
		System.out.println(answer);
	}
	private static int Calcul(Store store, Store dongun) {
		int dis=0;
		if(store.dir<=2 && dongun.dir<=2 && store.dir!=dongun.dir) {
			//북 남 있는 경우
			dis=Math.min((R+store.c+dongun.c), (R+2*C-store.c-dongun.c));
			
		}else if(store.dir>2 && dongun.dir>2&& store.dir!=dongun.dir) {
			dis=Math.min((C+store.r+dongun.r),(C+2*R-store.r-dongun.r));
		}
		else {
			dis=Math.abs(store.r-dongun.r)+Math.abs(store.c-dongun.c);
		}
		return dis;
	}
}
