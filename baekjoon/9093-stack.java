// [단어 뒤집기] https://www.acmicpc.net/problem/9093
// Stack 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> st = new Stack<>();

		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			char[] s = br.readLine().toCharArray();
			StringBuilder stringBuilder = new StringBuilder();
			for (char c : s) {
				if (c == ' ') {
					while (!st.empty()) {
						stringBuilder.append(st.pop());
					}
					stringBuilder.append(c);
				}
				else {
					st.push(c);
				}
			}
			while (!st.empty()) {
				stringBuilder.append(st.pop());
			}
			System.out.println(stringBuilder);
		}
	}
}
