package com.nhn.nhnTest;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-7%6);
	}
	static class Player{
		int num;
		char name;
		Player(char name){
			this.name=name;
			this.num=0;
		}
		@Override
		public String toString() {
			return name + " " + num;
		}
		
	}
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
	    char[] ansPlayer= new char[numOfAllPlayers];
	    int[] ansNum= new int[numOfAllPlayers];
	    int N=numOfAllPlayers-1;
	    boolean isQuick=false;
	    Player[] player = new Player[N];
	    Player sulle= new Player('A');
	    Player temp= new Player('A');
	    for (int i = 0; i < N; i++) {	//게임판
	    	int a=66+i;
			player[i]= new Player((char) a);
			//System.out.println(player[i]);
		}
	    int step=0;
	    sulle.num++;
	    
	    for (int i = 0; i < numOfGames; i++) {//게임 반복
	    	isQuick=false;
			step=(step+numOfMovesPerGame[i])%N;
			if(step<0)	step+=N;
			//System.out.println("step: "+step);
			temp.name=player[step].name;
			temp.num=player[step].num;
			for (int j = 0; j < numOfQuickPlayers; j++) {	//술래가 퀵 선수면
				if(temp.name==namesOfQuickPlayers[j]) {
					sulle.num++;
					isQuick=true;
					break;
				}
			}
			if(isQuick)
				continue;
			//아니면
			player[step].name=sulle.name;//원래 자리에 술래가 들어감
			player[step].num=sulle.num;
			sulle.name=temp.name;
			sulle.num=temp.num+1;
		}
	    
	    for (Player p : player) 
			System.out.println(p);
		System.out.println(sulle);
	  }
}
