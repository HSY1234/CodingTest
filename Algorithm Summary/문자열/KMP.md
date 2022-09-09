# KMP(Knuth-Morris-Pratt) 알고리즘

- 앞쪽 부터 비교 한다.
- 불일치가 발생한 텍스트 문자열의 앞 부분에 어떤 문자가 있는지를 미리 알고 있으므로, 불일치가 발생한 앞 부분에 대하여 다시 비교하지 않고 매칭을 수행
- 즉 앞에까지 맞은게 있다면, 그 정보를 최대한 다시 활용

```
ex) S="aaaaaaaaaab", W="aaaaab"에서 aaaaa는 앞에서 맞았다!
```

- 패턴을 전처리하여 부분일치 테이블 배열 pi[k]를 구해서 잘못된 시작을 최소화함
  - pi[k]: 처음부터 k인덱스까지를 끝으로 하는 부분 문자열에서 일치하는 **접두사**와 **접미사**가 일치하는 **최대길이**
- 틀린부분 앞에 있는것들이랑 앞에서 있는 부분끼리 같은 패턴을 보이는가?
- 시간 복잡도 O(M+N)

## 접두사 (prefix)와 접미사(suffix)

`banana`의 경우

- b의 접두사  
  b
- b의 접미사  
  b
- ba의 접두사  
  b  
  ba
- ba의 접미사  
  a  
  ba

- bab의 접두사  
  b  
  ba  
  bab
- bab의 접미사  
  b  
  ab  
  bab
- 접두사(banana의 접두사)  
  b  
  ba  
  ban  
  bana  
  banan  
  banana

- 접미사(banana의 접미사)  
  a  
  na  
  ana  
  nana  
  anana  
  banana

## 아이디어 결론!

주어진 문자열의 0~i까지 부분 문자열중(앞에서부터, 1<=i<=n)에서 prefix == suffix가 될수 있는 부분 문자열 중에서 가장 긴 것의 길이(최대길이 제외)한 테이블을 만들면 된다.

## 패턴을 이용한 부분일치 테이블 배열 작성

- 가장 중요한것은 일치한 부분에서 뒤에서부터 n개의 길이가, 앞에서부터 n개까지 일치하는 경우중에 최대길이를 찾아야한다.
- 매칭에 실패했을때 패턴포인터가 돌아갈 곳을 게산
- 패턴의 0번째 인덱스를 제외한 각 인덱스마다 맨 앞부터 해당 인덱스까지의 부분 문자열중 접두사와 접미사가 일치하는 최대길이로 계산해 측정

## 부분일치 테이블 만들기 아이디어

https://www.youtube.com/watch?v=KG44VoDtsAA

- 매우 흥미롭게도 부분일치 테이블을 만드는 행위는 KMP 알고리즘을 사용하는것과 같다!
- 자기 자신을 잘라서 원본 문자열로 생각하고, 패턴을 자기자신으로 생각해서 비교하는것 처럼 생각할수있다.
- 이게 무슨 소리냐 하면, 비교중인 접미사중에 가장 긴 값이 접미사와 일치하지 않을때, 접두사 패턴 매칭의 일부를 건너뛰고 다시 비교하면 되는데 이게 KMP 알고리즘과 같다.
- 앞에서 나보다 짧은 문자열 길이의 패턴의 테이블 계산 완료되었으므로, 다음 한칸 더 긴 문자열의 패턴 계산을 할때 이를 사용할수 있다. 즉 불일치시 몇칸 건너뛰어야하는지는 앞에서 이미 계산이 끝났다.
- 이를 이용해서 생각해보면
  - 이번 i, j가 일치하면 둘다 1씩증가하고 다시 비교 (KMP로치면 다음 문자 확인)
  - 이때 j가 패턴 길이만큼 되는일은 없으니 생략(KMP 원본에선 가능 그땐 찾은거니까 끝!)
  - 만약 i, j가 문자가 다르면 테이블을 참조해서 j값을 변경(마치 불일치시 kmp 테이블 참고해서 건너 뛰는 것 처럼)
  - 이를 통해 비교할 필요없는 경우를 건너뛰고 다시 j값으로 비교가능
  - 여기서 일치시 다시 첫번째 줄로
  - 여기서 틀리면 또 테이블을 참조해서 j값을 변경
  - 테이블값이 0이면(매칭할게 없다) => i만 1증가

## 부분일치 테이블 만들기

```java
// 부분일치테이블 만들기
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야한다.), j:접두사 포인터
	        while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1];

	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	        else pi[i] = 0;
	    }
```

## 실제 적용

문자열 매칭을 진행할때  
i는 문자열 전체에서 실제 좌표(텍스트 포인터)  
j는 우리가 찾을 문자열에서 그 문자열의 몇번째인지 좌표(패턴 포인터)

## 실제 구현

```java
public class KMP {
	public static void main(String[] args) throws Exception {
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();

		int tLength = text.length
		int pLength = pattern.length;

		// 부분일치테이블 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 우리는 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
	        while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1];
					// 나올땐 j=0이거나, 같은 패턴인 경우

	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	        else pi[i] = 0;
	    }

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터
		for(int i=0,j=0; i<tLength; ++i) {

			while(j>0 && text[i] != pattern[j]) j = pi[j-1];

			if(text[i] == pattern[j]) { //두 글자 일치
				if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면
					cnt++; // 카운트 증가
					list.add((i+1)-pLength);
					j=pi[j];
				}else {
					j++;
				}
			}
		}

		System.out.println(cnt);
		if(cnt>0) {
			System.out.println(list);
		}
	}
}
```
