# Queue

- 자바에서 queue는 LinkedList로 생성해야한다

## 선언

```java
import java.util.LinkedList; //import
import java.util.Queue; //import
Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
```

## 추가

```java
Queue<Integer> stack = new LinkedList<>();
queue.add(1);
queue.offer(3);
```

- add는 문제 발생시 예외 발생
- offer는 문제 발생시 false 반환

## 삭제

```java
queue.poll();       // queue에 첫번째 값을 반환하고 제거 비어있다면 null
queue.remove();     // queue에 첫번째 값 제거
queue.clear();  // 초기화
```

- poll 비었을시 null
- remove는 에러 발생

## 조회

```java
queue.peek();
```

## 기타

```java
queue.size();      // queue의 크기 출력
queue.isEmpty();     // queue 비어있는지
```
