import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2164_카드 {

	static String str = "6";

	public static void main(String[] args) throws Exception {
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new StringReader(str));

		int N = Integer.parseInt(in.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(q.size()!=1) {
			q.poll();
			int temp = q.poll();
			q.offer(temp);
		}
		System.out.println(q.peek());
	}

}
