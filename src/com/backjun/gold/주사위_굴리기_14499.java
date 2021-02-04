package com.backjun.gold;

import java.util.Scanner;

public class 주사위_굴리기_14499 {
	static class Dice{
		int[] noon = {1,2,3,4,5,6};
		int top=0,bottom=0,left=0,right=0,front=0,back=0,x,y;
		
		public void GoEast() {
			int temp=this.top;
			this.top=this.left;
			this.left=this.bottom;
			this.bottom=this.right;
			this.right=temp;
			this.y++;
		}
		
		public void GoWest() {
			int temp=this.top;
			this.top=this.right;
			this.right=this.bottom;
			this.bottom=this.left;
			this.left=temp;
			this.y--;
		}
		
		public void GoNorth() {
			int temp=this.top;
			this.top=this.front;
			this.front=this.bottom;
			this.bottom=this.back;
			this.back=temp;
			this.x--;
		}
		
		public void GoSouth() {
			int temp=this.top;
			this.top=this.back;
			this.back=this.bottom;
			this.bottom=this.front;
			this.front=temp;
			this.x++;
		}
	}
	static int N,M,x,y,K;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		K=sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				map[i][j]=sc.nextInt();
		}
		Dice dice = new Dice();
		dice.x=x;
		dice.y=y;
		map[dice.x][dice.y]=dice.bottom;
		for(int i=0;i<K;i++) {
			int dir=sc.nextInt();
			boolean isgo=true;
			switch(dir) {
				case 1:
					if(dice.y+1>=M) {
						isgo=false;
						break;
					}
					dice.GoEast();
					break;
				case 2:
					if(dice.y-1<0) {
						isgo=false;
						break;
					}
					dice.GoWest();
					break;
				case 3:
					if(dice.x-1<0) {
						isgo=false;
						break;
					}
					dice.GoNorth();
					break;
				case 4:
					if(dice.x+1>=N) {
						isgo=false;
						break;
					}
					dice.GoSouth();
					break;
			}
			if(isgo) {
				int kan = map[dice.x][dice.y];
				if(kan==0) {
					map[dice.x][dice.y]=dice.bottom;
				}else {
					dice.bottom=map[dice.x][dice.y];
					map[dice.x][dice.y]=0;
				}
				System.out.println(dice.top);
			}
		}
	}

}
