
public class 이차원배열접근 {
	public static void main(String args[]) {
		
		int n = 10;
		int m =12;
		
		int [][] arr = new int [n][m];
		

		int count =0;
		// 행 우선 순회
		//=>
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = count++;
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
		// 열 우선 순회
		// ↓
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
		//지그재그 순회
		// =>
		// <=
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j+(m-1-2*j)*(i%2)]+" ");
			}
			System.out.println();
		}
	}
}
