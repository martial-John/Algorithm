
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int N = s.length();
		char[] c = new char[N];
		for (int i = 0; i < N; i++) {
			c[i] = s.charAt(i);
		}
		
		int zero = 0;
		int one = 0;
		
		
		for (int i = 1; i < N; i++) {
			if(c[i-1] == '0') {
				if(c[i-1]!=c[i]) {
					zero++;
				}
			}
			else if(c[i-1] == '1'){
				if(c[i-1]!=c[i]) {
					one++;
				}
			}
			if(i==N-1) {
				if(c[i]=='0' && c[i] == c[i-1]) {
					zero++;
				}
				else if(c[i]=='1' && c[i] == c[i-1]) {
					one++;
				}
				else if(c[i]=='0' && c[i] != c[i-1]) {
					zero++;
				}
				else if(c[i]=='1' && c[i] != c[i-1]) {
					one++;
				}
			}
			
			
		}//for문
		
		
		
		int min = Math.min(zero, one);
		System.out.println(min);
		
		
		
	}
}
