import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

//	static String str = "10 512 512";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(find(N,r,c));
	}
	
	static int find(int N, int r, int c) {
		if(N==0) return 0;
		int half = 1<<(N-1);
		if(r<half && c<half) {
			return find(N-1,r,c);
		}
		
		if(r<half && c>=half) {
			return half*half +find(N-1,r,c-half);
		}
		
		if(r>=half && c<half) {
			return 2*half*half+find(N-1,r-half,c);
		}
		if(r >=half && c>=half) {
			return 3*half*half+find(N-1,r-half,c-half);
		}
		System.out.println("오류");
		return -1;
		
	}

}

