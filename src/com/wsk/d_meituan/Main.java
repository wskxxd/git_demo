package com.wsk.d_meituan;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0;
		int[] score = new int[n];
		for (int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
			if(score[0]>=score[i]){
				count++;
			}
		}
		
		int num = (int)(Math.log10(count)/Math.log10(2));
		System.out.println(num);
	}
}
