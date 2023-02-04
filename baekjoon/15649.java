import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N, M;
	static boolean[] visit;
	static Stack<Integer> stack = new Stack<>();

	public static void dfs() {
		if (stack.size() == M) {
			stack.forEach(it -> {
				System.out.print(it + " ");
			});
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				stack.add(i + 1);
				dfs();
				visit[i] = false;
				stack.pop();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		visit = new boolean[N];

		dfs();
	}
}
