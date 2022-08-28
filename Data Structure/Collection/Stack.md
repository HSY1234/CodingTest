# Stack

## 선언

```java
import java.util.Stack; //import
Stack<Integer> stack = new Stack<>();
Stack<String> stack = new Stack<>();
```

## 추가

```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
```

## 삭제

```java
stack.pop(); // 맨위 뺀값을 리턴
stack.clear(); // 전체
```

## 조회

```java
stack.peek();
```

## 기타

```java
stack.size();      // stack의 크기 출력 : 2
stack.isEmpty();     // stack이 비어있는제 check (비어있다면 true)
stack.contains(1) // stack에 1이 있는지 check (있다면 true)

```
