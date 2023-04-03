import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//	static String str = "10 8\r\n" + 
//			"3\r\n" + 
//			"0 3\r\n" + 
//			"1 4\r\n" + 
//			"0 2";
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int cut = Integer.parseInt(in.readLine());
		
		int width_cut [] = new int[cut+1];
		int height_cut [] = new int[cut+1];
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < cut; i++) {
			st = new StringTokenizer(in.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			
			if(flag == 1) {
				width_cut[x] = point;
				x++;
			}
			else if(flag == 0) {
				height_cut[y] = point;
				y++;
			}
		}
		
		width_cut[cut] = width;
		height_cut[cut] = height;
		
		
		Arrays.sort(width_cut);
		Arrays.sort(height_cut);
		
		
		int maxX= 0;
		int maxY= 0;
		
		x=0;
		y=0;
		
		for(int i=0; i<cut; i++) {
			x= width_cut[i+1] - width_cut[i];
			y= height_cut[i+1] - height_cut[i];
			
			if(x>maxX) maxX=x;
			if(y>maxY) maxY=y;
		}
		
		System.out.println(maxX*maxY);
		
	}
}