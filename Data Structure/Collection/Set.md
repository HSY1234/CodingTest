# Set

출처: https://coding-factory.tistory.com/554

- Set은 객체를 중복해서 저장할수 없고 하나의 null 값만 저장 가능
- 저장 순서가 유지되지 않음 기본은 HashSet
- 저장 순서를 원하면 LinkedHashSet
- 자동 정렬을 원하면 TreeSet
- HashSet은 hashCode() 메소드를 호출해서 해시 코드를 얻어내 해시코드를 비교하고 같다면
  equals() 메소드로 두 객체를 비교해서 true가 나와야 같은 객체로 판단
- 즉 내가 만든 클래스가 멤버변수 값이 같다면 Set에서 같은 취급을 해주려면, hashCode()를 오버라이딩해서 멤버변수로 hashCode값을 만들게하고, equals도 멤버변수가 서로 같은지 체크하게 오버라이딩 해야한다.
- String은 hashCode와 equals가 String 클래스에서 재정의되서 같은 문자열은 같은 객체로 판단

## 선언

```java
HashSet<Integer> set1 = new HashSet<Integer>();//HashSet생성
HashSet<Integer> set2 = new HashSet<>();//new에서 타입 파라미터 생략가능
HashSet<Integer> set3 = new HashSet<Integer>(set1);//set1의 모든 값을 가진 HashSet생성
HashSet<Integer> set4 = new HashSet<Integer>(10);//초기 용량(capacity)지정
HashSet<Integer> set5 = new HashSet<Integer>(10, 0.7f);//초기 capacity,load factor지정
HashSet<Integer> set6 = new HashSet<Integer>(Arrays.asList(1,2,3));//초기값 지정
```

## 추가

```java
HashSet<Integer> set = new HashSet<Integer>();//HashSet생성
set.add(1); //값 추가
```

- add는 문제 발생시 예외 발생
- offer는 문제 발생시 false 반환

## 삭제

```java
set.remove(1);//값 1 제거
set.clear();//모든 값 제거
```

- poll 비었을시 null
- remove는 에러 발생

## 조회

```java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성

System.out.println(set); //전체출력 [1,2,3]

Iterator iter = set.iterator();	// Iterator 사용
while(iter.hasNext()) {//값이 있으면 true 없으면 false
    System.out.println(iter.next());
}
```

## 기타

```java
queue.size();      // queue의 크기 출력
queue.isEmpty();     // queue 비어있는지

HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성
System.out.println(set.contains(1)); //set내부에 값 1이 있는지 check : true
```
