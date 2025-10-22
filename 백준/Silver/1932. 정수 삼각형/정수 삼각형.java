import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		int[][] DP = new int[N+1][N+1];
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i; j++) {
				arr[i-1][j] = Integer.parseInt(st.nextToken());
			}
		}
		DP[0][0] = arr[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				switch(j) {
				case 0 : DP[i][j] = DP[i-1][j] + arr[i][j]; break;
				default : DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + arr[i][j]; break;
				}
			}
		}
		
		int ans = 0;
		for(int c : DP[N-1]) ans = Math.max(ans, c);
			
		System.out.println(ans);
	}
}
