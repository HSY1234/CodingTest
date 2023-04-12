import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

//	static String str = "1 2 2	";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A,B,C));
		
	}
	
	static public long pow(int a, int k, int c) {
		if(k==1) return a%c;
		long temp = pow(a,k/2,c);
		temp = temp * temp % c;
		if(k%2==0) {

			return temp;
		}
		return temp * a % c;
	}

}
