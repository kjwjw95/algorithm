package com.programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutions s = new Solutions();
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 } };

		System.out.println(s.solution(board));
	}

}

class Solutions {
	class Robot {
		int row1, col1, row2, col2, dir, time;

		/*
		 * dir 0: 아래 1: 옆에
		 */
		public Robot(int r1, int c1, int r2, int c2, int dir, int time) {
			this.col1 = c1;
			this.col2 = c2;
			this.row1 = r1;
			this.row2 = r2;
			this.dir = dir;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Robot [row1=" + row1 + ", col1=" + col1 + ", row2=" + row2 + ", col2=" + col2 + ", dir=" + dir + ", time=" + time + "]";
		}

	}

	public int solution(int[][] board) {
		int answer = 0;
		int N = board.length;
		boolean[][][][] visit = new boolean[N][N][N][N];
		Queue<Robot> q = new LinkedList<Robot>();
		q.add(new Robot(0, 0, 0, 1, 0, 0));
		visit[0][0][0][1] = true;
		while (!q.isEmpty()) {
			Robot robot = q.poll();
			// System.out.println(robot);
			if ((robot.row1 == N - 1 && robot.col1 == N - 1) 
					|| (robot.row2 == N - 1 && robot.col2 == N - 1)) {
				return robot.time;
			}
			for (int i = 0; i < 4; i++) {
				Robot temp = Rotate(robot, board, i);
				if (temp == null)
					continue;
				if (!visit[temp.row1][temp.col1][temp.row2][temp.col2]) {
					visit[temp.row1][temp.col1][temp.row2][temp.col2] = true;
				//	Print(temp, board);
					q.add(temp);
				}
			}
			for (int i = 0; i < 4; i++) {
				Robot temp = Go(robot, board, i);
				if (temp == null)
					continue;
				if (!visit[temp.row1][temp.col1][temp.row2][temp.col2]) {
					visit[temp.row1][temp.col1][temp.row2][temp.col2] = true;
					q.add(temp);
				}
			}
		}
		return answer;
	}

	private void Print(Robot robot, int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (i == robot.row1 && j == robot.col1)
					System.out.print(5 + " ");
				else if (i == robot.row2 && j == robot.col2)
					System.out.print(5 + " ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private Robot Go(Robot robot, int[][] board, int i) {
		int[] dr1 = { 1, -1, 0, 0 };
		int[] dc1 = { 0, 0, 1, -1 };
		int[] dr2 = { 1, -1, 0, 0 };
		int[] dc2 = { 0, 0, 1, -1 };
		int nr1 = robot.row1 + dr1[i];
		int nc1 = robot.col1 + dc1[i];
		int nr2 = robot.row2 + dr2[i];
		int nc2 = robot.col2 + dc2[i];
		if (!Check(nr1, nc1, nr2, nc2, board))
			return null;
		return new Robot(nr1, nc1, nr2, nc2, robot.dir, robot.time + 1);
	}

	private boolean Check(int nr1, int nc1, int nr2, int nc2, int[][] board) {
		int size = board.length;
		if (nr1 < 0 || nr2 < 0 || nc1 < 0 || nc2 < 0 || nr1 >= size || nr2 >= size || nc1 >= size || nc2 >= size // 지도를 넘어가거나
				|| board[nr1][nc1] == 1 || board[nr2][nc2] == 1) // 공간에 1이 있거나
			return false;
		else
			return true;
	}

	private Robot Rotate(Robot robot, int[][] board, int i) {
		//System.out.println(robot.row1+" "+robot.col1+" "+robot.row2+" "+robot.col2);
		
		if (robot.dir == 0) {// 아래를 볼 때
			int[] dr1 = { 1, 1, -1, -1, 0, 0, 0, 0 };
			int[] dc1 = { 0, 1, 0, 1, 0, 0, 0, 0 };
			int[] dr2 = { 0, 0, 0, 0, 1, 1, -1, -1 };
			int[] dc2 = { 0, 0, 0, 0, 0, -1, 0, -1 };
			int nr1 = 0, nr2 = 0, nc1 = 0, nc2 = 0;
			for (int j = 0; j < 2; j++) {
				nr1 = robot.row1 + dr1[i * 2 + j];
				nc1 = robot.col1 + dc1[i * 2 + j];
				nr2 = robot.row2 + dr2[i * 2 + j];
				nc2 = robot.col2 + dc2[i * 2 + j];
//				System.out.println(nr1+" "+nc1+" "+nr2+" "+nc2);
//				System.out.println();
				if (!Check(nr1, nc1, nr2, nc2, board))
					return null;
			}
			//System.out.println(nr1+" "+nc1+" "+nr2+" "+nc2);
			int[] loc = sorts(nr1, nc1, nr2, nc2);
//			for (int j = 0; j < loc.length; j++) {
//				System.out.print(loc[i]+" ");
//			}
//			System.out.println();
			return new Robot(loc[0], loc[1], loc[2], loc[3], 1, robot.time + 1);
		} else {// 옆에 를 볼 떄
			int[] dr1 = { 0, 1, 0, 1, 0, 0, 0, 0 };
			int[] dc1 = { 1, 1, -1, -1, 0, 0, 0, 0 };
			int[] dr2 = { 0, 0, 0, 0, 0, -1, 0, -1 };
			int[] dc2 = { 0, 0, 0, 0, 1, 1, -1, -1 };
			int nr1 = 0, nr2 = 0, nc1 = 0, nc2 = 0;
			for (int j = 0; j < 2; j++) {
				nr1 = robot.row1 + dr1[i * 2 + j];
				nc1 = robot.col1 + dc1[i * 2 + j];
				nr2 = robot.row2 + dr2[i * 2 + j];
				nc2 = robot.col2 + dc2[i * 2 + j];
				if (!Check(nr1, nc1, nr2, nc2, board))
					return null;
			}
			//System.out.println(nr1+" "+nc1+" "+nr2+" "+nc2+" "+i);
			int[] loc = sorts(nr1, nc1, nr2, nc2);
			return new Robot(loc[0], loc[1], loc[2], loc[3], 0, robot.time + 1);
		}
	}

	private int[] sorts(int nr1, int nc1, int nr2, int nc2) {
		int[] tmp = new int[4];
		if (nr1 < nr2) {
			tmp[0] = nr1;
			tmp[1] = nc1;
			tmp[2] = nr2;
			tmp[3] = nc2;
		} else if (nr2 < nr1) {
			tmp[0] = nr2;
			tmp[1] = nc2;
			tmp[2] = nr1;
			tmp[3] = nc1;
		} else if (nr1 == nr2) {
			if (nc1 < nc2) {
				tmp[0] = nr1;
				tmp[1] = nc1;
				tmp[2] = nr2;
				tmp[3] = nc2;
			} else if (nc1 > nc2) {
				tmp[0] = nr2;
				tmp[1] = nc2;
				tmp[2] = nr1;
				tmp[3] = nc1;
			}
		}
		return tmp;
	}
}