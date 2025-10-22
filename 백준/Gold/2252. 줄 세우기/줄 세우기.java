import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] adj = new List[N+1];
		int[] cnt = new int[N+1];
		for(int i = 0 ; i < N+1; i++) adj[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmpa = Integer.parseInt(st.nextToken());
			int tmpb = Integer.parseInt(st.nextToken());
			
			adj[tmpa].add(tmpb);
			cnt[tmpb]++;
		}
		
		int idx = N;
		while(idx >= -1) {
			
			for(int i = 1; i < N+1; i++) {
				if(cnt[i] == 0) {
					sb.append(i + " ");
					cnt[i] = -1;
					
					for(int j = 0; j < adj[i].size();) cnt[adj[i].remove(j)]--;
				}
			}
			idx--;
		}
		System.out.println(sb.toString());
	}
}
