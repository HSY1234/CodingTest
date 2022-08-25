
public class 델타4방탐색 {
	
	static int [] dx = {-1,1,0,0};// 상하좌우
	static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		int n=10;
		int m=10;
		
		int [][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0;  k < 4; k++) {//4방 탐색
					int nx = i+dx[k];
					int ny = j+dy[k];
					if (nx<0 || nx>=n || ny<0 || ny>=m) {
						continue;
					}
					System.out.println(arr[nx][ny]);
				}
			}
		}
		
	}
}
