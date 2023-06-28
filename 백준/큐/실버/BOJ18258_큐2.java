import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18258_큐2 {

//	static String str = "15\r\n" + 
//			"push 1\r\n" + 
//			"push 2\r\n" + 
//			"front\r\n" + 
//			"back\r\n" + 
//			"size\r\n" + 
//			"empty\r\n" + 
//			"pop\r\n" + 
//			"pop\r\n" + 
//			"pop\r\n" + 
//			"size\r\n" + 
//			"empty\r\n" + 
//			"pop\r\n" + 
//			"push 3\r\n" + 
//			"empty\r\n" + 
//			"front";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		
		int N = Integer.parseInt(in.readLine());
		int last = 0;
//		for (int n = 0; n < N; n++) {
//			st = new StringTokenizer(in.readLine());
//			String command = st.nextToken();
//			switch(command) {
//				case "push":
//					int value = Integer.parseInt(st.nextToken());
//					q.offer(value);
//					last = value;
//					break;
//				case "pop":
//					if(q.isEmpty()) sb.append(-1).append('\n');
//					else sb.append(q.poll()).append('\n');
//					break;
//				case "size":
//					sb.append(q.size()).append('\n');
//					break;
//				case "empty":
//					if(q.isEmpty()) sb.append(1).append('\n');
//					else sb.append(0).append('\n');
//					break;
//				case "front":
//					if(q.isEmpty()) sb.append(-1).append('\n');
//					else sb.append(q.peek()).append('\n');
//					break;
//				case "back":
//					if(q.isEmpty()) sb.append(-1).append('\n');
//					else sb.append(last).append('\n');
//			}
//		}
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			switch(command.charAt(1)) {
				case 'u':
					int value = Integer.parseInt(st.nextToken());
					q.offer(value);
					last = value;
					break;
				case 'o':
					if(q.isEmpty()) sb.append(-1).append('\n');
					else sb.append(q.poll()).append('\n');
					break;
				case 'i':
					sb.append(q.size()).append('\n');
					break;
				case 'm':
					if(q.isEmpty()) sb.append(1).append('\n');
					else sb.append(0).append('\n');
					break;
				case 'r':
					if(q.isEmpty()) sb.append(-1).append('\n');
					else sb.append(q.peek()).append('\n');
					break;
				case 'a':
					if(q.isEmpty()) sb.append(-1).append('\n');
					else sb.append(last).append('\n');
			}
		}
//		for (int n = 0; n < N; n++) {
//			st = new StringTokenizer(in.readLine());
//			String command = st.nextToken();
//			char c = command.charAt(1);
//			if (c == 'u') {
//				int value = Integer.parseInt(st.nextToken());
//				q.offer(value);
//				last = value;
//			}
//			else if(c== 'o') {
//				if(q.isEmpty()) sb.append(-1).append('\n');
//				else sb.append(q.poll()).append('\n');
//			}
//			else if(c== 'i') {
//				sb.append(q.size()).append('\n');
//			}
//			else if(c== 'm') {
//				if(q.isEmpty()) sb.append(1).append('\n');
//				else sb.append(0).append('\n');
//			}
//			else if(c== 'r') {
//				if(q.isEmpty()) sb.append(-1).append('\n');
//				else sb.append(q.peek()).append('\n');
//			}
//			else if(c== 'a') {
//				if(q.isEmpty()) sb.append(-1).append('\n');
//				else sb.append(last).append('\n');
//			}
//		}
		System.out.println(sb.toString());
		
	}

}
