import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1244_스위치켜고끄기 {
	
//	static String str = "21\r\n" + 
//			"0 1 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
//			"2\r\n" + 
//			"1 3\r\n" + 
//			"2 3";
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		
		int [] arr = new int[n+1];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i+1] = Integer.parseInt(st.nextToken());
		}
		
		
		
		int student = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < student; i++) {
			
			st = new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			int index = number;
			if(gender==1) {
				while(index<=n) {
					arr[index] ^=1;//XOR 연산이 더 빠름
//					arr[index] = change(arr[index]);
					index+=number;
				}
			}
			if(gender==2) {
				arr[index] ^=1;//XOR 연산이 더 빠름
//				arr[index] = change(arr[index]);
				
				int k=1;
				while(index-k>=1&&index+k<=n) {
					if(arr[index-k]==arr[index+k]){
						
						arr[index-k]^=1;//XOR 연산이 더 빠름
						arr[index+k]^=1;//XOR 연산이 더 빠름
						
//						arr[index-k]=change(arr[index-k]);
//						arr[index+k]=change(arr[index+k]);
						k++;
					}
					else {
						break;
					}
				}
			}
			
		}
		
		for (int i = 1; i < n+1; i++) {
			sb.append(arr[i]);
			sb.append(" ");
			if(i%20==0) sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
//	public static int change(int state) {
//		if(state==0) return 1;
//		if(state==1) return 0;
//		System.out.println("문제발생");
//		return -1;
//	}
}
