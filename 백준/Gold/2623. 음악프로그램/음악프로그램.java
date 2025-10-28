import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] cnt = new int[N+1];
    	List<Integer>[] adjList = new ArrayList[N+1];
    	for(int i = 0 ; i < N+1; i ++ ) adjList[i] = new ArrayList<>();
    	for(int i = 0; i  < M; i++) {
    		String[] tmp = br.readLine().split(" ");
    		for(int j = 2; j < tmp.length; j++) {
    			adjList[Integer.parseInt(tmp[j-1])].add(Integer.parseInt(tmp[j]));
    			cnt[Integer.parseInt(tmp[j])]++;
    		}
    	}
    	Deque<Integer> q = new ArrayDeque<>();
    	for (int i = 1; i < cnt.length; i++) {
    		if(cnt[i] == 0) {
    			q.offer(i);
    			for(int j = 0; j < adjList[i].size();) cnt[adjList[i].remove(0)]--;
    			cnt[i] = -1;
    		}
    	}
    	Deque<Integer> result = new ArrayDeque<>();
    	while(!q.isEmpty()) {
    		int curr = q.poll();
    		result.offer(curr);
    		for(int j = 0; j < adjList[curr].size();) cnt[adjList[curr].remove(0)]--;
    		for(int i = 1; i < cnt.length; i++) if(cnt[i]== 0) {
    			q.offer(i);
    			cnt[i] = -1;
    		}
    	}
    	
    	if(result.size() != N) System.out.println(0);
    	else { 
    		for(int i = 0; i < result.size();)sb.append(result.poll()+"\n");
    		System.out.println(sb);
    	}
    }
}