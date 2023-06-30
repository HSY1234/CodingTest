import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5430_AC {

//	static String str = "4\r\n" + 
//			"RDD\r\n" + 
//			"4\r\n" + 
//			"[1,2,3,4]\r\n" +
//			"DD\r\n" + 
//			"1\r\n" + 
//			"[42]\r\n" + 
//			"RRD\r\n" + 
//			"6\r\n" + 
//			"[1,1,2,3,5,8]\r\n" + 
//			"D\r\n" + 
//			"0\r\n" + 
//			"[]";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		Deque<Integer> q = new LinkedList<Integer>();
		
		for (int tc = 0; tc < T; tc++) {
			String command = in.readLine();
			int n = Integer.parseInt(in.readLine());
			String array = in.readLine();
			
			boolean reverse = false;
			boolean result = true;
			st = new StringTokenizer(array.substring(1, array.length()-1),",");
			
			for (int i = 0; i < n; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
//			System.out.println(q.size());
			
			for (int i = 0; i < command.length(); i++) {
				if(command.charAt(i) == 'R') {
					reverse = !reverse; 
				}
				else {
					if(reverse) {
						if(q.isEmpty()) {
							result = false;
							break;
						}
						q.pollLast();
						
					}
					else {
						if(q.isEmpty()) {
							result = false;
							break;
						}
						q.pollFirst();
					}
						
				}
			}
			
			if(!result) sb.append("error\n");
			else {
				sb.append("[");
				if(reverse) {
					Iterator<Integer> itr = q.descendingIterator();
					while(itr.hasNext()) {
						sb.append(itr.next()).append(',');
					}
					if(!q.isEmpty()) sb.setLength(sb.length()-1);
				}
				else {
					for (int i : q) {
						sb.append(i).append(',');
					}
					if(!q.isEmpty()) sb.setLength(sb.length()-1);
				}
				sb.append("]\n");
			}
			q.clear();
			
		}
		System.out.println(sb.toString());
	}

}
