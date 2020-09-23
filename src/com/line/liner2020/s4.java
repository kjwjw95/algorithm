package com.line.liner2020;

public class s4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4 s = new Solution4();
		int[][] a = { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		System.out.println(s.solution(a));
	}

}

class Solution4 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public int solution(int[][] maze) {
		int answer = 0;
		int dir = 1; // 0:위 1:오른 2:아래 3:왼
		int r = 0;
		int c = 0;
		int size = maze.length;
		while (true) {
			if (r == size - 1 && c == size - 1) {
				break;
			}
			int nr = r + dr[dir % 4];
			int nc = c + dc[dir % 4];	//왼쪽 벽
			int ddr= r+ dr[(dir+1)%4];
			int ddc= c+ dc[(dir+1)%4];	//목표
			if ((nr < 0 || nc < 0 || nr >= size || nc >= size || maze[nr][nc] == 1)
					&& (ddr>=0 && ddr<size && ddc>=0 && ddc<size && maze[ddr][ddc]==0)) {
				r = ddr;
				c = ddc;
			} else if (nr>=0 && nr<size && nc>=0 && nc<size && maze[nr][nc]==0) {
				System.out.println("turn left");
				dir--;
				if(dir<0)
					dir+=4;
				r=nr;
				c=nc;
			} else if ((ddr < 0 || ddc < 0 || ddr >= size || ddc >= size || maze[ddr][ddc] == 1)
					&& (nr < 0 || nc < 0 || nr >= size || nc >= size || maze[nr][nc] == 1)
					&&(r + dr[(dir+2) % 4]>=0 && r + dr[(dir+2) % 4]<size 
					&& c + dc[(dir+2) % 4]>=0 && c + dc[(dir+2) % 4]<size 
					&& maze[r + dr[(dir+2) % 4]][c + dc[(dir+2) % 4]]==0)) {
				System.out.println("turn right");
				dir++;
				r+= dr[(dir+1)%4];
				c+= dc[(dir+1)%4];
			} else {
				System.out.println("turn back");
				dir += 2;
				r+= dr[(dir+1)%4];
				c+= dc[(dir+1)%4];
			}
			answer++;
		}
		return answer;
	}
}