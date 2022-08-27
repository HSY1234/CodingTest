# NextPermutation(순열 생성4)

- 배열을 우선 오름차순으로 정렬한후 시작!
- 가장 큰 내림차순을 만들때 까지 사전순으로 다음으로 큰 순열 생성
  1. 뒤쪽부터 탐색하며 교환위치(i-1) 찾기(i: 꼭대기)
  2. 뒤쪽부터 탐색하며 교환위치(i-1) 와 교환할 큰값 위치(j) 찾기
  3. 두 위치 값(i-1,j) 교환
  4. 꼭대기 위치(i)부터 맨 뒤까지 오름차순 정렬 (어차피 내림차순이 되어 있으니 양끝을 바꾸면서 가운데로 오다보면 내림차순 => 오름차순이 됨)

## 구현

```java
public class NextPermutationTest {
	static int N , input[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i <	N; i++) {
			input[i]=sc.nextInt();
		}

		//1. 오름차순 정렬
		Arrays.sort(input);

		do {
			System.out.println(Arrays.toString(input));
		} while (np());
	}

	private static boolean np() {

		//1 교환위치 찾기
    // while문 나오면 i값은 0 or 꼭대기
		int i = N-1;
		while(i>0&&input[i-1]>=input[i]) --i;

		if(i==0) return false; // 다음 np가 없음

		// 2. 교환위치에 교환할 값 찾기
    // i-1은 꼭대기 바로 앞의 값, 교환할 값은 꼭대기 앞의 값보단 큰 값
		int j = N-1;
		while(input[i-1]>=input[j]) j--;

		//3. 교환위치와 교환할 값 교환하기
		swap(i-1,j);

		//4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들수 있는 가장 작은 순열생성(오름차순 정렬)
    // 이미 내림차순이라 양끝씩 바꾸면 오름차순으로 바뀐다.
		int k = N-1;
		while(i<k) {
			swap(i++,k--);
		}

		return true;
	}

	public static void swap(int i, int j) {
		int temp =input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
```
