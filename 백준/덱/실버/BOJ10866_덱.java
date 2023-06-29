import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10866_덱 {

	static String str = "";

	public static void main(String[] args) throws Exception {
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new StringReader(str));

		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			switch(command.charAt(1)) {
				case 'u':
					int value = Integer.parseInt(st.nextToken());
					if(command.charAt(5) == 'f') {
						dq.offerFirst(value);
					}
					else {
						dq.offerLast(value);
					}
					break;
				case 'o':
					if(dq.isEmpty()) sb.append(-1).append('\n');
					else {
						if(command.charAt(4) == 'f') {
							sb.append(dq.pollFirst()).append('\n');
						}
						else {
							sb.append(dq.pollLast()).append('\n');
						}
					}
					break;
				case 'i':
					sb.append(dq.size()).append('\n');
					break;
				case 'm':
					if(dq.isEmpty()) sb.append(1).append('\n');
					else sb.append(0).append('\n');
					break;
				case 'r':
					if(dq.isEmpty()) sb.append(-1).append('\n');
					else sb.append(dq.peekFirst()).append('\n');
					break;
				case 'a':
					if(dq.isEmpty()) sb.append(-1).append('\n');
					else sb.append(dq.peekLast()).append('\n');
			}
		}
		System.out.println(sb.toString());
	}

}
