// [암호 만들기] https://www.acmicpc.net/problem/1759

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int L, C;
	static char[] words;
	public static int vowelCount(String word) {
		int count = 0;
		for (int i=0;i<word.length();i++) {
			if(word.charAt(i) == 'a'
				|| word.charAt(i) == 'e'
				|| word.charAt(i) == 'i'
				|| word.charAt(i) == 'o'
				|| word.charAt(i) == 'u'
			) {
				count ++;
			}
		}
		return count;
	}
	public static void dfs(int index, String word) {
		if (word.length() == L) {
			int vowelCount = vowelCount(word);
			if (vowelCount >= 1 && L - vowelCount >= 2) {
				System.out.println(word);
			}
			return;
		}

		for (int i = index; i < C; i++) {
			dfs(i + 1, word.concat(Character.toString(words[i])));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C= Integer.parseInt(input[1]);
		words = new char[C];

		for (int i = 0; i < C; i++) {
			char w = (char) br.read();
			br.read();
			words[i] = w;
		}

		Arrays.sort(words);

		dfs(0, "");

		br.close();
	}
}
