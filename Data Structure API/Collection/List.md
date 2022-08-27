# List

- List는 Collection interface를 상속받는다.
- Collection의 함수를 모두 사용할수 있다.
- List는 내부적으로 배열로 구성 되어있다. 배열과 차이점은 size가 변하면 내부적으로 배열의 길이를 두배로 늘려준다.(값의 복사가 일어난다.)
- List 자료 삭제시, size가 유동적으로 바뀌기 때문에 index 차감을 위해 뒤에서 부터 삭제하는게 좋다.

# 선언

- new ArrayList(): 기본크기 10인 배열
- new ArrayList(기본 크기): 기본 크기를 지정
- ArrayList\<Generic\> al = new ArrayList\<Generic\>(): 해당 Generic으로 생성

- LinkedList li = new LinkedList();
- LinkedList<Integer> li = new LinkedList<Integer>();
- LinkedList<Integer> li = new LinkedList<>() // 생략가능

# 추가

- add(int index, E element)
- addAll(int index, Collection<? extends E> c)

# 조회

- get(int index)
- indexOf(Object o)
- lastIndexOf(Object o)
- listIterator()

# 삭제

- remove(int index)

# 수정

- set(int index, E element)

# 기타

- subList(int fromIndex, int toIndex)
