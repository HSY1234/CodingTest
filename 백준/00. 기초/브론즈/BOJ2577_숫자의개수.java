import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		int[] count = new int[10];
		
		int A = Integer.parseInt(in.readLine());
		int B = Integer.parseInt(in.readLine());
		int C = Integer.parseInt(in.readLine());
		
		int D = A*B*C;
		
		String s = Integer.toString(D);
		
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '0';
			count[index]++;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}

}
