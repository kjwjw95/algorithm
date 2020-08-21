package com.swea.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/Flatten.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			int[] a = new int[100];
			for (int i = 0; i < 100; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);

			for (int i = 0; i < dump; i++) {
				if (a[99] == a[0])
					break;
				if (--a[99] - ++a[0] < 2)
					break;
				Arrays.sort(a);
			}
			System.out.println("#" + t + " " + (a[99] - a[0]));
		}
		sc.close();
	}
}