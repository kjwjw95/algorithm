package com.programmers.kakao;

public class 기둥과보 {

	public static void main(String[] args) {
		int[] n = { 5, 5, 10 };
		int[][][] build_frame = {
				{ { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 }, { 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } },
				{ { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 },
						{ 1, 1, 1, 0 }, { 2, 2, 0, 1 } },
				{ { 1, 0, 0, 1 }, { 2, 1, 1, 1 }, { 2, 0, 0, 1 }, { 1, 0, 0, 2 }, { 1, 1, 2, 1 }, { 1, 2, 2, 1 }, { 0, 2, 1, 1 }, { 3, 2, 1, 1 } }

		};
		Solution s = new Solution();
		for (int i = 0; i < n.length; i++) {
			int[][] ans = s.solution(n[i], build_frame[i]);
			Print(ans);
			System.out.println();
		}
	}

	private static void Print(int[][] ans) {
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Solution {
		public int[][] solution(int n, int[][] build_frame) {
			boolean[][][] map = new boolean[n + 1][n + 1][2];
			int size = build_frame.length;
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				int x = build_frame[i][0];
				int y = build_frame[i][1];
				int a = build_frame[i][2];
				int b = build_frame[i][3];
				if (b == 1) {   //설치
					if (a == 0 && CanBuild0(x, y, map)) {
						// 기둥설치 가능하면 기둥 설치
						map[y][x][a] = true;
						cnt++;
					} else if (a == 1 && CanBuild1(x, y, map)) {
						// 보 설치 가능하면 보 설치
						map[y][x][a] = true;
						cnt++;
					}
				} else if (b == 0) {
                    map[y][x][a] = false;
					if (isRight(map)) {
						cnt--;
					} else {
						map[y][x][a] = true;
					}
				}
				//PrintMap(map);
			}
			int[][] answer = new int[cnt][3];
			int idx = 0;
			for (int x = 0; x <= n; x++) {
				for (int y = 0; y <= n; y++) {
                    for(int a=0;a<2;a++){
                        if (map[y][x][a]) {
						    int[] temp = { x, y , a };
						    answer[idx++] = temp;
					    }
                    } 
				}
			}
			return answer;
		}

		private boolean isRight(boolean[][][] map) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j][0]) {
						if(!CanBuild0(j, i, map))
							return false;
					}
                    if(map[i][j][1]) {
						if(!CanBuild1(j, i, map)) 						
							return false;
                    }
				}
			}
			return true;
		}

		private boolean CanBuild1(int x, int y, boolean[][][] map) {
			if (map[y-1][x][0] //보 아래에 기둥이 있는경우
					|| (x<map.length-1 && map[y-1][x+1][0]) //보 오른쪽 아래에 기둥이 있는 경우
					||( (x<map.length-1 && map[y][x+1][1]) 
                       && (x > 0 && map[y][x - 1][1]))) //보 양쪽에 보가 있는 경우
				return true;
			 else
				return false;
		}

		private boolean CanBuild0(int x, int y, boolean[][][] map) {
			if(y==0 	// 바닥인 경우
					|| (x>0 && map[y][x-1][1])	//보 위일 경우
                    || map[y][x][1]    //보 위일 경우
					|| (y>0 && map[y-1][x][0]))	//기둥 위일 경우
				return true;
			else
				return false;
		}

		private void PrintMap(int[][] map) {
			// TODO Auto-generated method stub
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[map.length - i - 1][j]);
				}
				System.out.println();
			}
			System.out.println();
		}

		
	}
}
