import java.io.BufferedReader;
import java.io.InputStreamReader;


public class  Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] count = new int[10];
		int N = Integer.parseInt(in.readLine());
		
		String s = Integer.toString(N);
		
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '0';
			count[index]++;
		}
		
		count[6] += count[9];
		
		if(count[6]%2 == 0) {
			count[6] /= 2;
		}
		else {
			count[6] /= 2;
			count[6]++;
		}
		
		int max = 0;
		
		for (int i = 0; i < 9; i++) {
			max = Math.max(max, count[i]);
		}
		
		System.out.println(max);
	}

}
