import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//	static String str = "2\r\n" + 
//			"1 2\r\n" + 
//			"3 5\r\n" + 
//			"5 9\r\n" + 
//			"5 7\r\n" + 
//			"3 8\r\n" + 
//			"0 6\r\n" + 
//			"6 10\r\n" + 
//			"8 11\r\n" + 
//			"8 12\r\n" + 
//			"2 13\r\n" + 
//			"1 4";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		Meet[] meeting = new Meet[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			meeting[i] = new Meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		
		Arrays.sort(meeting);
//		List<Meet> list = new ArrayList<>(Arrays.asList(meeting));
		
		int counter = 0;
		int end = 0;
		
		for (int i = 0; i < meeting.length; i++) {
			if(meeting[i].start >= end) {
				counter++;
				end = meeting[i].end;
			}
		}
		
		System.out.println(counter);
		
	}

}

class Meet implements Comparable<Meet>{
	int start;
	int end;
	
	public Meet(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meet o){
		if(this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}
	
	@Override
	public String toString() {
		return start+" "+end;
	}
	
}
