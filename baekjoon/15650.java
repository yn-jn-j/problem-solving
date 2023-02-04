package com.example.problemsolvingjava;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, M;
	static boolean[] visit;
	static Stack<Integer> stack = new Stack<>();

	public static void dfs(int index) {
		if (stack.size() == M) {
			stack.forEach(it -> {
				System.out.print(it + " ");
			});
			System.out.println();
			return;
		}
		for (int i = index; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				stack.add(i + 1);
				dfs(i);
				visit[i] = false;
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		visit = new boolean[N];

		dfs(0);
	}
}
