// [가르침] https://www.acmicpc.net/problem/1062

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, k;
	static final boolean[] visit = new boolean[26];
	static String[] words;
	static int maxCount = 0;

	public static void dfs(int start, int count) {
		if(count == k) {
			int wordCount = 0;
			for (String st : words) {
				boolean know = true;
				for(int l = 0; l < st.length(); l++) {
					if(!visit[st.charAt(l)- 'a']) {
						know = false; break;
					}
				}
				if(know) wordCount++;
			}
			maxCount = max(wordCount, maxCount);
			return;
		}
		for (int i = start; i < 26; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, count + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nk = br.readLine().split(" ");
		n = Integer.parseInt(nk[0]);
		k= Integer.parseInt(nk[1]);
		words = new String[n];

		if(k < 5) {
			System.out.println(0);
			return;
		}
		if (k >= 26) {
			System.out.println(n);
			return;
		}

		for (int i = 0; i < n; i++) {
			String w = br.readLine();
			words[i] = w;
		}

		k-=5;

		visit[0] = true; visit['n'-'a'] = true; visit['t'-'a']=true;
		visit['i'-'a'] = true; visit['c'-'a'] = true;

		dfs(0, 0);

		System.out.println(maxCount);
		br.close();
	}
}
