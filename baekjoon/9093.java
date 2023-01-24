// [단어 뒤집기] https://www.acmicpc.net/problem/9093

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			List<String> sentence = Arrays.asList(br.readLine().split(" "));
			sentence.forEach(
				it -> System.out.print(new StringBuffer(it).reverse() + " ")
			);
			System.out.println();
		}
	}
}
