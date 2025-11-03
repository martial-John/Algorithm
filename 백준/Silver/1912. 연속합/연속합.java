import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(st.nextToken());
    	int[] data = new int[N];
    	int[] DP = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0 ;  i < N; i ++)data[i] = Integer.parseInt(st.nextToken());
    	DP[0] = data[0];
    	int max = DP[0];
    	for(int i = 1 ; i < N; i++) {
    		DP[i] = Math.max(DP[i-1] + data[i] , data[i]);
    		max = Math.max(DP[i], max);
    	}
    	System.out.println(max);
    }
}