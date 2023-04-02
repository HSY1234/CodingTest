# 자바 코테 팁

1. `int`보다 `long`으로 정수 타입을 선언할것
2. `Scanner`보다 `bufferedReader`을 사용할것
3. 오름차순 내림차순

```java
// 오름차순
int A[] = {5,4,3,2,1};
Arrays.sort(A);

// 내림차순 (Wrapper 사용)
Integer A[] = {1,2,3,4,5};
Arrays.sort(A,Collections.reverseOrder());

// int 배열
int A[] = {1,2,3,4,5};
Integer[] tmp = Arrays.stream(A).boxed().toArray(Integer[]::new);
Arrays.sort(tmp, Collections.reverseOrder());

// 모든 배열에 -1 곱하고 오름차순하고 다시 -1 곱하는 방법도 있다
```

4. MOD 연산은 덧셈,뺄셈,곱셈에서 분배법칙이 성립하므로, 범위 넘기전에 미리미리 하기
