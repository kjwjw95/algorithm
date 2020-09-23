package com.line.liner2020;

public class s6 {

	public static void main(String[] args) {

	}

}

class Solution {
	static int[][] box;

	public int solution(int[][] boxes) {
		int answer = 0;
		box = boxes;
		boolean ischange = false;
		for (int i = 0; i < box.length - 1; i++) { // 첫 박스 선택
			if(box[i][0]==box[i][1])
				continue;
			ischange = false;
			System.out.println(i);
			System.out.println(answer);
			Print();
			for (int j = 0; j < 2; j++)
			{ // 첫 박스 선택
				
				int a = box[i][j];
				for (int k = i + 1; k < box.length; k++) 
				{ // 둘째 박스 선택
					for (int l = 0; l < 2; l++) 
					{ // 둘째 박스 선택
						int b = box[k][l];
						if (a == b) 
						{
							Change(i, j, k, l);
							ischange = true;
							break;
						}
					}
					if (ischange)
						break;
					else
						answer++;
				}
				if (ischange)
					break;
				
				else if (!ischange && j==1) {
					answer++;
					System.out.println(i+" "+j+" ");
				}
			}
		}
		if(box[box.length][0]!=box[box.length][1])
			answer++;
		return answer;
	}

	private void Change(int i, int j, int k, int l) {
		int t = (j == 1) ? 0 : 1;
		int temp = box[i][t];
		box[i][t]=box[k][l];
		box[k][l]=temp;
		Print();
	}

	private void Print() {
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(box[i][j]);
			}
			System.out.println();
		}
	}

}